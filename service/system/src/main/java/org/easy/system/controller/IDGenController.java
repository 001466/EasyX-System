package org.easy.system.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.easy.system.feign.IDGenFeign;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(IDGenFeign.PATH)
@Api(value = "ID",tags = "ID")
@Slf4j
@EnableScheduling
public class IDGenController implements IDGenFeign,InitializingBean {


	@Bean("incrementIdRedisTemplate")
	protected RedisTemplate<String, Object> incrementIdRedisTemplate(RedisConnectionFactory connectionFactory) {

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();



		ObjectMapper objectMapper = new ObjectMapper();
		// 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);


		RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);

		RedisTemplate<String, Object> redisTemplate=new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setValueSerializer(jsonSerializer);
		redisTemplate.setHashValueSerializer(jsonSerializer);

		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setHashKeySerializer(stringRedisSerializer);

		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}


	@Autowired
	@Qualifier("incrementIdRedisTemplate")
	RedisTemplate incrementIdRedisTemplate;

	private static final long SUFFIX=1000;
	private static final int PREFIX=100;
	private static final AtomicLong RANDOM=new AtomicLong(new Random().nextInt(PREFIX));
	private  static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyMMdd");


	private static final String INCREMENT_ID_KEY="INCREMENT_ID";
	private static RedisAtomicLong redisAtomicLong = null;

	@Override
	@ApiOperation(
			value = "获取Long id",
			notes = "获取Long id"
	)
	public long next() {
		if(!incrementIdRedisTemplate.hasKey(INCREMENT_ID_KEY)){
			return reset();
		}
		return redisAtomicLong.getAndIncrement();
	}

	@Override
	@ApiOperation(
			value = "获取Uuid",
			notes = "获取Uuid"
	)
	public String uuid() {
		long id=next();
		String uuid= DigestUtils.md5DigestAsHex(String.valueOf(id).getBytes());
		return uuid;
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		reset();
	}

	@Scheduled(cron = "${id.reset.cron:0 1 0 * * ?}")
	public long reset(){
		if(RANDOM.get()>PREFIX) {
			RANDOM.set(0);
		}
		long id= ((Long.parseLong(FORMAT.format(new Date()))*PREFIX+ RANDOM.incrementAndGet()) * SUFFIX);
		log.info("Reset ID = "+id);
		redisAtomicLong = new RedisAtomicLong(INCREMENT_ID_KEY, incrementIdRedisTemplate.getConnectionFactory());
		redisAtomicLong.set(id);
		return redisAtomicLong.getAndIncrement();
	}
}