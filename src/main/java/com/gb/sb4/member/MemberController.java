package com.gb.sb4.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberJoin")
	public ModelAndView setInsert(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("member/memberJoin");
		}		
		// 에러가 아닐 경우
		else {
			int result = memberService.setInsert(memberVO);
			mv.addObject("msg", "가입 완료");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	// Join
	@GetMapping("memberJoin")
	public void setInsert(MemberVO memberVO) throws Exception{}
	
	// MyPage
	@GetMapping("memberPage")
	public void getMemberPage() throws Exception{}
	
	// 로그아웃 하기
	@GetMapping("memberLogOut")
	public String getMemberLogOut(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	// 로그인하기
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getMemberLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}else {
			String message = "Login Fail";
			mv.addObject("msg", message);
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	// 로그인 페이지 이동
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
	}
}
