package com.dg.s10.board.notice;

import java.util.List;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardFilesDTO;

public class NoticeDTO extends BoardDTO{
	//is a
	//has a 
	private List<BoardFilesDTO> files;

	public List<BoardFilesDTO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}
	
	
	

}
