package com.gb.sb4.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gb.sb4.board.BoardVO;
import com.gb.sb4.board.notice.NoticeMapper;
import com.gb.sb4.board.notice.NoticeVO;
import com.gb.sb4.util.Pager;

// 기본적인 객체 생성 Annotation
@Component
public class CustomSchedule {
	
	@Autowired
	private NoticeMapper noticeMapper;

	//@Scheduled(fixedRate = 1000, initialDelay = 2000)
	//@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void fixedRateTest() throws Exception{
		// 메서드가 실행되고 있는 쓰레드의 이름을 가져온다
		System.out.println(Thread.currentThread().getName());
		System.out.println("----------- Fixed Rate Test ------------");
	}
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 2000)
	public void fixedDelayTest() throws Exception{
		System.out.println(Thread.currentThread().getName());
		
		System.out.println("----------- Fixed Delay Test -----------");
	}
	
	//@Scheduled(cron = " * * * * * * ")
	public void cronTest() throws Exception{
		// 현재 시간 출력
		System.out.println(Thread.currentThread().getName());
		System.out.println("--------- Cron Test -------------");
		Calendar ca = Calendar.getInstance();
		System.out.println(ca.getTime());
		
		Pager pager = new Pager();
		pager.setCurPage(1);
		pager.makeRow();
//		List<BoardVO> ar = noticeMapper.getList(pager);
//		for(BoardVO boardVO : ar) {
//			System.out.println(boardVO.getTitle());
//		}
		
	}
}
