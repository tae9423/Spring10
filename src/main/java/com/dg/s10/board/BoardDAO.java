package com.dg.s10.board;

import java.util.List;

import com.dg.s10.util.Pager;

public interface BoardDAO {
	
	//file
	public int setFile(BoardFilesDTO boardFilesDTO)throws Exception;
		
	//전체 갯수
	public Long getCount(Pager pager)throws Exception; 
		
	//List
	public abstract List<BoardDTO>  getList(Pager pager)throws Exception;
		
	//상세
	public abstract BoardDTO getSelect(BoardDTO boardDTO)throws Exception;
		
	//조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO)throws Exception;
		
	//글쓰기
	public int setInsert(BoardDTO boardDTO)throws Exception;
		
	//글삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
		
	//글수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	
	
	
}
