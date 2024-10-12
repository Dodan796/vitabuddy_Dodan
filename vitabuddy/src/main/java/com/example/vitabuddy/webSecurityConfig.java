package com.example.vitabuddy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http.csrf(csrf->csrf.disable())
			.formLogin(formLogin->formLogin.disable())
			.headers(headerConfig->headerConfig.frameOptions(frameOptionConfig->frameOptionConfig.disable()))
		 	.authorizeRequests(authz -> authz
		    .requestMatchers("/uploads").permitAll()); // 파일 업로드 엔드포인트 허용
		    // 나머지 요청은 인증 필요
		return http.build();
	}
	
	
	
	
}