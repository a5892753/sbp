package com.newer.sbpdemo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.newer.sbpdemo.mapper")
@EnableCaching
@EnableRedisHttpSession
public class SbpdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbpdemoApplication.class, args);
	}
}
