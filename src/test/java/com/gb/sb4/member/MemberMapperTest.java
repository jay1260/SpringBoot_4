package com.gb.sb4.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(value = true)
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void getMemberLoginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test1234");
		memberVO.setPw("1234");
		memberVO = memberMapper.getMemberLogin(memberVO);
		
		assertNotNull(memberVO);
	}
	
	@Test
	void setInsertTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("testId2");
		memberVO.setPw("test");
		memberVO.setName("test name");
		memberVO.setAge(22);
		memberVO.setEmail("test@test.test");
		
		int result = memberMapper.setInsert(memberVO);
		
		assertEquals(1, result);
	}
	
	@Test
	void setInsertFileTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("testId");
		memberFileVO.setFileName("file Name");
		memberFileVO.setOriName("test oriName");
		
		int result = memberMapper.setInsertFile(memberFileVO);
		
		assertNotEquals(0, result);
	}

}
