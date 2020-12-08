package com.gb.sb4.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

// 파일경로 지정 메서드
@Component
public class FilePathGenerator {
	
	@Autowired
	private ResourceLoader resourceLoader;

	// 1. ResourceLoader 사용
	public File getUseResourceLoader(String filePath) throws Exception{
		// 매개변수 filePath는 /static/은 제외한 하위의 경로명
		
		// 실제 경로
		String path = "classpath:/static/";
		
		//resourceLoader.getResource(path);
		
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
}
