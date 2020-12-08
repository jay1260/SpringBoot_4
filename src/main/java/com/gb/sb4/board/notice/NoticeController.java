package com.gb.sb4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gb.sb4.board.BoardVO;
import com.gb.sb4.board.file.FileVO;
import com.gb.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// application.properties에 있는 프로퍼티 불러다 쓰는 경우
	@Value("${board.notice.filePath}")
	private String filePath;
	
	// model.addAttribute("board", "notice") << 자동으로 실행되는 코드로 보면 된다.
	// Controller에서 모든 메서드에 적용
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	// FileDown을 위한 fnum을 파라미터로 받아오기 위한 매개변수 FileVO
	@GetMapping("noticeFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		fileVO = noticeService.getFile(fileVO);
		//System.out.println(fileVO.getFileName());
		
		mv.addObject("fileVO", fileVO);
		mv.addObject("filePath", filePath);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardVO);
		if(result>0) {
			mv.addObject("msg", "삭제되었습니다.");
			mv.addObject("path", "./noticeList");
		}
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setUpdate(boardVO);
		if(result>0) {
			mv.addObject("msg", "글이 수정되었습니다.");
			mv.addObject("path", "./noticeList");
		}
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardVO boardVO, long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getOne(boardVO);
		System.out.println(num);
		
		mv.addObject("update", boardVO);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardVO = noticeService.getOne(boardVO);
		
		mv.addObject("select", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}

	// noticeList
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	// noticeWrite
	@GetMapping("noticeWrite")
	public String setInsert() throws Exception{
		
		return "board/boardWrite";
	}
	
	// noticeWrite
	@PostMapping("noticeWrite")
	public String setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception{
		int result = noticeService.setInsert(boardVO,files);
		return "redirect:./noticeList";		
	}
	
}
