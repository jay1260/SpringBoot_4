package com.gb.sb4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gb.sb4.interceptor.CustomInterceptor;
import com.gb.sb4.interceptor.NoticeAdminInterceptor;
import com.gb.sb4.interceptor.NoticeMemberInterceptor;
import com.gb.sb4.interceptor.QnaMemberInterceptor;
import com.gb.sb4.interceptor.QnaWriterInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private NoticeAdminInterceptor noticeAdminInterceptor;
	
	@Autowired
	private NoticeMemberInterceptor noticeMemberInterceptor;
	
	@Autowired
	private QnaMemberInterceptor qnaMemberInterceptor;
	
	@Autowired
	private QnaWriterInterceptor qnaWriterInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 적용할 Interceptor 등록
		registry.addInterceptor(customInterceptor)
		
		// Interceptor에서 사용할 URL 작성
		.addPathPatterns("/notice/**")
		
		// Interceptor에서 제외 할 URL 작성
		.excludePathPatterns("/notice/noticeWrite");
		
		registry.addInterceptor(noticeAdminInterceptor)
		
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeUpdate")
		.addPathPatterns("/notice/noticeDelete");
		
		registry.addInterceptor(noticeMemberInterceptor)
		.addPathPatterns("/notice/**")
		.excludePathPatterns("/notice/noticeList");
		
		registry.addInterceptor(qnaMemberInterceptor)
		.addPathPatterns("/qna/**")
		.excludePathPatterns("/qna/qnaList");
		
		registry.addInterceptor(qnaWriterInterceptor)
		.addPathPatterns("/qna/qnaUpdate")
		.addPathPatterns("/qna/qnaDelete")
		.addPathPatterns("/qna/qnaWrite");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
