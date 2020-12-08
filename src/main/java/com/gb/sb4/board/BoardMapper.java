package com.gb.sb4.board;

import java.util.List;

import com.gb.sb4.board.file.FileVO;
import com.gb.sb4.util.Pager;

public interface BoardMapper {
	
	public long getCount(Pager pager) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public int setInsert(BoardVO boardVO) throws Exception;
	
	// file upload
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	// title, contents update
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	// 글 하나 삭제
	public int setDelete(BoardVO boardVO) throws Exception;
	
	// 글 번호를 이용한 해당 글번호 조회
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	// 파일을 가져오는 거
	public FileVO getFile(FileVO fileVO) throws Exception;
	
}
