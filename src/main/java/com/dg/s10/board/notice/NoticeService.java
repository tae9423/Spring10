package com.dg.s10.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardFilesDTO;
import com.dg.s10.board.BoardService;
import com.dg.s10.util.FileManager;
import com.dg.s10.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext serveltContext;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return noticeDAO.getFiles(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
				
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		// 1. 어느 폴더
		String realPath = this.serveltContext.getRealPath("/resources/upload/notice/");
		System.out.println("RealPath : " + realPath);
		File file = new File(realPath);
		
		System.out.println("Before Num : "+boardDTO.getNum());
		
		int result = noticeDAO.setInsert(boardDTO);
		
		System.out.println("After Num : "+boardDTO.getNum());
		
		
		for (MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			result = noticeDAO.setFile(boardFilesDTO);

		}

		// 3. 파일 저장
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		String realPath = serveltContext.getRealPath("/resources/upload/notice/");
		
		//2. 어느 파일
		BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
		
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		for(int i=0; i< ar.size(); i++) {
			//3. 파일 삭제
			File file = new File(realPath, ar.get(i).getFileName());
			file.delete();
		}
		
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
