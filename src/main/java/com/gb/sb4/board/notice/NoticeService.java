package com.gb.sb4.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gb.sb4.board.BoardService;
import com.gb.sb4.board.BoardVO;
import com.gb.sb4.board.file.FileVO;
import com.gb.sb4.util.FileManager;
import com.gb.sb4.util.FilePathGenerator;
import com.gb.sb4.util.Pager;

@Service
// Exception이 발생하면 rollback을 해라
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileManager fileManager;
	
	// application.properties에 있는 프로퍼티 불러다 쓰는 경우
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		
		long totalCount = noticeMapper.getCount(pager);
		pager.makePage(totalCount);
		
		return noticeMapper.getList(pager);
	}
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		
		int result = noticeMapper.setInsert(boardVO);
		System.out.println("NUM : "+ boardVO.getNum());
		
		// 1차 HDD에 File 저장
		// -- 저장할 폴더의 실제 경로명
		// 이 경로는 테스트 진행 후 지워서 프로퍼티에 경로를 정의하여 불러다 쓴다
		//String filePath = "upload/notice";
		
		File file = filePathGenerator.getUseResourceLoader(this.filePath);
		
		// 2차
		for(MultipartFile multipartFile : files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			System.out.println(fileName);
			
			// File DB 테이블 만든 후
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartFile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
		
			result = noticeMapper.setInsertFile(fileVO);
		}
		
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return noticeMapper.getOne(boardVO);
	}
	
	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {

		return noticeMapper.getFile(fileVO);
	}
	
}
