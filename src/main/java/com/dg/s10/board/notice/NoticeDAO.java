package com.dg.s10.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dg.s10.board.BoardDAO;
import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardFilesDTO;
import com.dg.s10.board.CommentsDTO;
import com.dg.s10.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.dg.s10.board.notice.NoticeDAO.";
	
	public int setFileDelete(BoardFilesDTO boardFilesDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setFileDelete", boardFilesDTO);
	}
	
	public int setCommentUpdate(CommentsDTO commentsDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setCommentUpdate", commentsDTO);
	}
	
	public int setCommentDelete(CommentsDTO commentsDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setCommentDelete", commentsDTO);
	}
	
	public Long getCommentCount(CommentsDTO commentsDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentCount", commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(Map<String, Object> map)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCommentList", map);
	}
	
	public int setComments(CommentsDTO commentsDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setComments", commentsDTO);
	}
	
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getFiles", boardDTO);
	}

	@Override
	public int setFile(BoardFilesDTO boardFilesDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setFile", boardFilesDTO);
	}

	@Override
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}
	
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
