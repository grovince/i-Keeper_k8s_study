package com.springdemo.bootboard.config;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springdemo.bootboard.security.SpringBoardUserDetailsService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { // spring mvc 설정을 구현하는 인터페이스  (sevlet-context.xml)

	@Bean // mvc 설정 파일 (web.xml) 에서 filter 등록작업을 @Bean 으로 수행
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return filter;
	}
	
	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		// @ResponseBody 응답에 대한 인코딩 설정
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}
	
//	@Bean // apache commons fileupload library 를 사용해서 파일 업로드 처리를 수행하는 bean 등록
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//		resolver.setDefaultEncoding("UTF-8");
//		resolver.setMaxUploadSize(1024 * 1024 * 5); // 파일 하나당 5MB
//		
//		return resolver;
//	}
	
	// input type hidden 으로 보낸 _method 의 값을 읽는 객체
	@Bean
	public HiddenHttpMethodFilter methodFilter() {
		return new HiddenHttpMethodFilter();
	}

	@Bean
	public SpringBoardUserDetailsService userDetailService() {
		return new SpringBoardUserDetailsService();
	}
	
}
