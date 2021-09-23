package com.dg.s10.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dg.s10.MyJunitTest;
import com.dg.s10.board.notice.NoticeDAO;

public class CommentDAOTest extends MyJunitTest{

	@Autowired
	private NoticeDAO noticeDAO;
	
	
	@Test
	public void test()throws Exception{
		for(int i=0;i<100;i++) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setNum(483L);
			commentsDTO.setWriter("tae9423");
			commentsDTO.setContents("comments"+i);
			commentsDTO.setBoard("N");
			noticeDAO.setComments(commentsDTO);
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("Finish");
	}

}
