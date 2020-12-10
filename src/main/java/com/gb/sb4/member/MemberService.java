package com.gb.sb4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	// 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		// result = true -> 검증 위반으로 (실패)
		// result = false -> 검증 성공
		boolean result = false;
		
		// 기본 Annotation 검증 결과
		if(bindingResult.hasErrors()) {
			result = true;
		}
		
		// password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			//bindingResult.rejectValue("VO의 해당 멤버변수", "properties 파일의 코드(키)","코드가 없으면 기본 메세지");
			bindingResult.rejectValue("pw2", "memberVO.password.notEqual");
			result = true;
		}
		
		// id 중복 검사 검증
		// idCheck 쿼리를 만들어서 검증만 진행한다.
		MemberVO mv = memberMapper.getMemberIdCheck(memberVO);
		// 이미 있는 아이디일 경우 error
		if(mv!=null) {
			bindingResult.rejectValue("id", "memberVO.idCheck.notNull");
			result = true;
		}
		
		return result;
	}
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getMemberLogin(memberVO);
	}
	
	public int setInsert(MemberVO memberVO) throws Exception{
		return memberMapper.setInsert(memberVO);
	}
}
