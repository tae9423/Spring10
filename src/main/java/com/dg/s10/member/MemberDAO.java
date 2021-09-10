package com.dg.s10.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.dg.s10.member.MemberDAO.";
	

	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	public MemberDTO getIdCheck(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getIdCheck", memberDTO);
	}
	
	

}
