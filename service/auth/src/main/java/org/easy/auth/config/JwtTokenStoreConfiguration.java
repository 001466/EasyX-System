/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.easy.auth.config;

import org.easy.auth.support.BladeJwtTokenEnhancer;
import org.easy.secure.constant.TokenConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * JwtTokenStore
 *
 */
@Configuration

public class JwtTokenStoreConfiguration {

	/**
	 * 使用jwtTokenStore存储token
	 */
	@Bean
	@ConditionalOnProperty(prefix = "auth.security.oauth2", name = "storeType", havingValue = "jwt", matchIfMissing = true)
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Autowired
	private UserDetailsService userDetailsService;


	@Bean
	public UserAuthenticationConverter userAuthenticationConverter() {
		DefaultUserAuthenticationConverter defaultUserAuthenticationConverter = new DefaultUserAuthenticationConverter();
		defaultUserAuthenticationConverter.setUserDetailsService(userDetailsService);
		return defaultUserAuthenticationConverter;
	}
	/**
	 * 用于生成jwt
	 */
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey(TokenConstant.SIGN_KEY);
		((DefaultAccessTokenConverter) accessTokenConverter.getAccessTokenConverter())
			.setUserTokenConverter(userAuthenticationConverter());
		return accessTokenConverter;
	}

	/**
	 * 用于扩展jwt
	 */
	@Bean
	@ConditionalOnMissingBean(name = "jwtTokenEnhancer")
	public TokenEnhancer jwtTokenEnhancer() {
		return new BladeJwtTokenEnhancer();
	}

}
