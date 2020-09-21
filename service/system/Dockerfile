FROM adoptopenjdk/openjdk8-openj9:alpine-slim

MAINTAINER lijianfa1985@163.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

EXPOSE 8001

ADD ./target/system-1.0-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=dev"]
