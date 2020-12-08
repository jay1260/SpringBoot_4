package com.gb.sb4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gb.sb4.board.BoardVO;
import com.gb.sb4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "삭제되었습니다.");
			mv.addObject("path", "./qnaList");
		}
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardVO);
		if(result>0) {
			mv.addObject("msg", "글이 수정되었습니다.");
			mv.addObject("path", "./qnList");
		}
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getOne(boardVO);
		System.out.println(num);
		
		mv.addObject("update", boardVO);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public String setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception{
		int result = qnaService.setInsert(boardVO, files);
		return "redirect:./qnaList";
	}
	
	@GetMapping("qnaWrite")
	public String setInsert() throws Exception{
		
		return "board/boardWrite";
	}

	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getOne(boardVO);
		
		mv.addObject("select", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
}
