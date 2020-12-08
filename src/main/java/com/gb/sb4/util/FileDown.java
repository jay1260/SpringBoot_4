package com.gb.sb4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.gb.sb4.board.file.FileVO;

@Component("fileDown")
public class FileDown extends AbstractView{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//System.out.println("File Down View");
		
		/** 1. 파일이 저장된 폴더 까지만의 경로
		Controller에 model에 담긴 filePath를 가져온다.*/
		String filePath = "classpath:/static/"+(String)model.get("filePath");
		// 가져온 filePath가 정상 작동하는지 테스트
		//System.out.println("FilePath : " + filePath);
		
		/** 2. 저장되 파일명 까지 설정
		 Controller에 model에 담긴 fileVO를 가져온다.*/
		FileVO fileVO = (FileVO)model.get("fileVO");
		
		filePath = filePath+"/"+fileVO.getFileName();
		// 폴더 경로와 저장된 파일명이 정상 경로로 작동하는지 print 테스트
		//System.out.println(filePath);
		
		// 3. 위에 정보를 이용해서 File 객체를 생성 ResourceLoader 변수 선언
		File file = resourceLoader.getResource(filePath).getFile();
		
			// 3-1 File 한글 처리
		response.setCharacterEncoding("UTF-8");
		
			// 3-2 총 File의 크기
		response.setContentLengthLong(file.length());
		
			// 3-3 다운로드시 파일 이름 인코딩 처리
		String fileName = URLEncoder.encode(fileVO.getOriName(), "UTF-8");
		
			// 3-4 어떤이름으로 설정할 것인가 header 설정
		response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// HDD에서 파일을 읽을 준비 (연결)
		FileInputStream fi = new FileInputStream(file);
		// Client로 전송 준비
		OutputStream os = response.getOutputStream();
		
		// 최종 전송
		FileCopyUtils.copy(fi, os);
		
		// 자원 해제 (연결 해제)
		
		os.close();
		fi.close();
		
		
	}
}
