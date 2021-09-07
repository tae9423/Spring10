package com.dg.s10.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaSerivce qnaService;
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	
	
	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv, Pager pager)throws Exception{
		List<BoardDTO> ar = qnaService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		
		mv.setViewName("board/list");
		return mv;
	}

}
