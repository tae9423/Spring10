package com.dg.s10.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO memberDAO;
	

	@Test
	public void getIdCheckTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("DG");
		memberDTO = memberDAO.getIdCheck(memberDTO);
		assertNotNull(memberDTO);
	}

}
