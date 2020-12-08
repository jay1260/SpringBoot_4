package com.gb.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gb.sb4.member.MemberRoleVO;
import com.gb.sb4.member.MemberVO;

@Component
public class QnaMemberInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		boolean result = false;
		if(memberVO !=null) {
			List<MemberRoleVO> roles = memberVO.getRoles();
			for(MemberRoleVO memberRoleVO : roles) {
				if(memberRoleVO.getRole()!=null) {
					result = true;
					break;
				}
					
			}
		}
		if(!result) {
			request.setAttribute("msg", "member 등급 이상부터 접근 가능합니다.");
			request.setAttribute("path", "./qnaList");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}
}
