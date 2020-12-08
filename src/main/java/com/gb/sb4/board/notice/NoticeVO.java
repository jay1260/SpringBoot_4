package com.gb.sb4.board.notice;

import java.util.List;

import com.gb.sb4.board.BoardVO;
import com.gb.sb4.board.file.FileVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVO extends BoardVO{
	
	private List<FileVO> files;

}
