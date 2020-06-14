package com.example.study.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration  //설정파일
@EnableJpaAuditing //Jpa 감사 활성화
public class JpaConfig {
}
