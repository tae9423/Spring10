package com.dg.s10.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardService;
import com.dg.s10.util.Pager;

@Service
public class QnaSerivce implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		return 0;
	}

}
