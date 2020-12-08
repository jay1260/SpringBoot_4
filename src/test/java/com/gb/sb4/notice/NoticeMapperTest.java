package com.gb.sb4.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gb.sb4.board.BoardVO;
import com.gb.sb4.board.notice.NoticeMapper;
import com.gb.sb4.board.notice.NoticeVO;
import com.gb.sb4.util.Pager;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void getListTest() throws Exception{
		long curPage = 1;
		Pager pager = new Pager();
		pager.setCurPage(curPage);
		pager.makeRow();
		//pager.setKind("writer");
		//pager.setSearch("r9");
		List<BoardVO> ar = noticeMapper.getList(pager);
		
		assertEquals(10, ar.size());
	}
	
	//@Test
	void setInsertTest()throws Exception{
		for(int i = 0; i<100; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("title"+i);
			noticeVO.setWriter("writer"+i);
			noticeVO.setContents("contents"+i);
			int result = noticeMapper.setInsert(noticeVO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		
		System.out.println("Insert Finish");
	}
	
	//@Test
	void setUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("update Title");
		noticeVO.setContents("update Contents");
		noticeVO.setNum(3);
		int result = noticeMapper.setUpdate(noticeVO);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	void setDeleteTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(4);
		
		int result = noticeMapper.setDelete(noticeVO);
		
		assertNotEquals(0, result);
	}
	
	//@Test
	void getOneTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(2);
		noticeVO = (NoticeVO)noticeMapper.getOne(noticeVO);

		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getWriter());
		System.out.println(noticeVO.getContents());
		
		assertNotNull(noticeVO);
	}

}
