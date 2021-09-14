package com.dg.s10.member;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public MemberFilesDTO getFile(MemberDTO memberDTO)throws Exception{
		return memberDAO.getFile(memberDTO);
	}

	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.getLogin(memberDTO);
	}

	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return memberDAO.getIdCheck(memberDTO);
	}

	public int setJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		
		//1. 어느 폴더에 저장
		// /resources/upload/member
		//2. application(ServletContext)객체 필요
		
		int result = memberDAO.setJoin(memberDTO);
		
		if(photo!=null) {
		
		ServletContext sContext = session.getServletContext();
		String realPath = sContext.getRealPath("/resources/upload/member/");
		System.out.println("RealPath : "+realPath);
		
		//3. 폴더 확인
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//4. 중복되지 않는 파일이름 생성
		//a. 시간 -> 밀리세컨즈
		//b. UUID
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+photo.getOriginalFilename();
		System.out.println(fileName);
		
		file = new File(file, fileName);
		
		//5. 폴더에 파일을 저장
		//1) MultipartFile의 transferTo 메서드 사용
		//photo.transferTo(file);
		
		//2) Spring의 API FileCopyUtils의 copy 메서드 사용
		FileCopyUtils.copy(photo.getBytes(), file);
		
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		memberFilesDTO.setId(memberDTO.getId());
		memberFilesDTO.setFileName(fileName);
		memberFilesDTO.setOriName(photo.getOriginalFilename());
		result = memberDAO.setFileInsert(memberFilesDTO);
		}	
		return result;			
	}

	public int setUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.setUpdate(memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO)throws Exception{
		return memberDAO.setDelete(memberDTO);
	}

}
