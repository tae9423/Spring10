package com.dg.s10.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dg.s10.member.MemberFilesDTO;

@Component
public class FileManager {
	// fileDelete
	public void fileDelte(File file) throws Exception {
		file.delete();
	}

	// fileSave
	// 파일 저장

	public String fileSave(MultipartFile multipartFile, File file) throws Exception {

		if (!file.exists()) {
			file.mkdirs();
		}

		// 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + multipartFile.getOriginalFilename();

		file = new File(file, fileName);

		// 저장
		// 1. FileCopyUtils
		// FileCopyUtils.copy(multipartFile.getBytes(), file);

		// 2. MultipartFile
		multipartFile.transferTo(file);

		return fileName;

	}

}
