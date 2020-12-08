package com.gb.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gb.sb4.board.BoardVO;
import com.gb.sb4.board.qna.QnaMapper;
import com.gb.sb4.member.MemberRoleVO;
import com.gb.sb4.member.MemberVO;

@Component
public class QnaWriterInterceptor implements HandlerInterceptor{
	
	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		boolean result = false;
		
		String path = request.getRequestURI();
		String kind = path.substring(path.lastIndexOf("qna")).replace("qna", "");
		
		String message = "권한이 없습니다.";
		
		if(memberVO != null) {
			List<MemberRoleVO> roles = memberVO.getRoles();
			for(MemberRoleVO memberRoleVO : roles) {
				if(memberRoleVO.getRole() != null) {
					if(kind.equals("Write")) {
						result = true;
						break;
					}else {
						int num = Integer.parseInt(request.getParameter("num"));
						BoardVO boardVO = new BoardVO();
						boardVO.setNum(num);
						boardVO = qnaMapper.getOne(boardVO);
						
						if(memberVO.getId().equals(boardVO.getWriter())) {
							result = true;
							break;
						}else {
							message = "작성자만 접근 가능합니다.";
						}
					}
				}
			}
		}
		
		if(!result) {
			request.setAttribute("msg", message);
			request.setAttribute("path", "./qnaList");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);		
		}
		
		return result;
	}
}
