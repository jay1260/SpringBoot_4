package com.gb.sb4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustromAOP {

	@Before("execution(* com.gb.sb4.board.notice.*Service.get*(..))")
	public void noticeBefore() throws Exception{
		System.out.println("---------Point Cut이 실행되기 전---------");
	}
	
	// After
	// NoticeService get으로 시작하는 모든 메서드들 실행 후 작동하는 Advice 메서드
	@After("execution(* com.gb.sb4.board.notice.NoticeService.get*(..))")
	public void noticeAfter() throws Exception{
		System.out.println("---------Point Cut 실행된 후 -----------");
	}
	
	// Around
	// NoticeService set으로 시작하는 모든 메서드들 실행 전, 후 작동하는 Advice 메서드
	@Around("execution(* com.gb.sb4.board.notice.NoticeService.set*(..))")
	public Object noticeAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("----Around 실행 전");
		Object obj = null;
		
		obj = joinPoint.proceed(); // point cut 실행
		
		System.out.println("-----Around 실행 후");
		
		return obj;
	}
}
