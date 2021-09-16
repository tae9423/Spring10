package com.dg.s10.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardFilesDTO;
import com.dg.s10.board.BoardService;
import com.dg.s10.member.MemberFilesDTO;
import com.dg.s10.util.FileManager;
import com.dg.s10.util.Pager;

@Service
public class QnaSerivce implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext serveltContext;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return qnaDAO.getFiles(boardDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		String realPath = this.serveltContext.getRealPath("/resources/upload/qna/");
		System.out.println("RealPath : " + realPath);
		File file = new File(realPath);
		
		System.out.println("Before Num : "+boardDTO.getNum());
		
		int result = qnaDAO.setInsert(boardDTO);
		
		System.out.println("After Num : "+boardDTO.getNum());
		
		
		for (MultipartFile multipartFile : files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			result = qnaDAO.setFile(boardFilesDTO);

		}

		// 3. 파일 저장
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		List<BoardFilesDTO> ar = qnaDAO.getFiles(boardDTO);
		
		//파일 위치
		String realPath = serveltContext.getRealPath("/resources/upload/qna/");
		//2. 어느 파일
		
		for(BoardFilesDTO bdto : ar) {
			File file = new File(realPath, bdto.getFileName());
			fileManager.fileDelte(file);
		}
		
		//3. 파일 삭제
		return qnaDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		//1. 부모의 정보 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}

}
