package com.dg.s10.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.dg.s10.board.BoardDTO;
import com.dg.s10.board.BoardFilesDTO;
import com.dg.s10.board.CommentsDTO;
import com.dg.s10.member.MemberDTO;
import com.dg.s10.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private ServletContext servletContext;
	
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	public ModelAndView getCommentList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<CommentsDTO> commentsDTOs = noticeService.getCommentsList(pager);
		mv.addObject("pager", pager);
		return mv;
	}
		
	@PostMapping("comment")
	public ModelAndView setComments(CommentsDTO commentsDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		commentsDTO.setBoard("N");
		
		int result = noticeService.setComments(commentsDTO);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		System.out.println(commentsDTO.getNum());
		System.out.println(commentsDTO.getWriter());
		System.out.println(commentsDTO.getContents());
				
		return mv;
	}

	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardFilesDTO);
		mv.setViewName("fileDown");
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception {
		int result = noticeService.setDelete(boardDTO);
		ModelAndView mv = new ModelAndView();
		String message = "Delete Fail";
		if(result>0) {
			message="Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("url", "./list");
		
		mv.setViewName("common/result");
		return mv;
	}
	
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		List<CommentsDTO> comments =noticeService.getComments(boardDTO);
		List<BoardFilesDTO> ar= noticeService.getFiles(boardDTO);
		//mv.addObject("fileList", ar);
		mv.addObject("comments", comments);
		mv.addObject("dto", boardDTO);
		mv.addObject(getBoard(), ar);
		mv.addObject(getBoard(), comments);
		mv.setViewName("board/select");
		return mv;
		
	}
	
	@GetMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		mv = new ModelAndView();
		
		mv.setViewName("board/insert");
		return mv;
	}
	
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception{
		//original fileName 출력
		
		for(MultipartFile muFile: files) {
			System.out.println(muFile.getOriginalFilename());
		}
		
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		
		return mv;
	}

}
