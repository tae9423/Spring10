package com.dg.s10.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("reply")
	public ModelAndView setReply(QnaDTO qnaDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(qnaDTO);
		
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReply()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		return mv;
		
	}
	
	@GetMapping("insert")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return mv;
	}	
	
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
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
