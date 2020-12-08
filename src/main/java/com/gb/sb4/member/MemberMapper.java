package com.gb.sb4.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	// 회원가입
	public int setInsert(MemberVO memberVO) throws Exception;
	
	// 파일 넣기
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception;
	
	// 로그인
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
	
}
