package com.dg.s10.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardFilesDTO;
import com.dg.s10.board.BoardService;
import com.dg.s10.board.CommentsDTO;
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
	
	public int setFileDelete(BoardFilesDTO boardFilesDTO)throws Exception{
		//폴더에서 파일 삭제
		String realPath = serveltContext.getRealPath("/resources/upload/notice/");
		
		File file = new File(realPath,boardFilesDTO.getFileName());
		fileManager.fileDelte(file);
		
		return noticeDAO.setFileDelete(boardFilesDTO);
	}
	
	public int setCommentUpdate(CommentsDTO commentsDTO)throws Exception{
		return noticeDAO.setCommentUpdate(commentsDTO);
	}
	
	public int setCommentDelete(CommentsDTO commentsDTO)throws Exception{
		
		return noticeDAO.setCommentDelete(commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(CommentsDTO commentsDTO, Pager pager)throws Exception{
		pager.setPerPage(5L);
		pager.makeRow();
		Long totalCount = noticeDAO.getCommentCount(commentsDTO);
		pager.makeNum(totalCount);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("comments", commentsDTO);
		map.put("pager", pager);
		return noticeDAO.getCommentList(map);
	}
	
	public int setComments(CommentsDTO commentsDTO)throws Exception{
		return noticeDAO.setComments(commentsDTO);
	}
	
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
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		String realPath = serveltContext.getRealPath("/resources/upload/notice/");
		
		//2. 어느 파일
		for(BoardFilesDTO bdto : ar) {
			//3. 파일 삭제
			File file = new File(realPath, bdto.getFileName());
			fileManager.fileDelte(file);
		}

		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
