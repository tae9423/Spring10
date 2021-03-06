package com.dg.s10.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("delete")
	public ModelAndView setDelete(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.setDelete(memberDTO);
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
		
	}

	@GetMapping("update")
	public ModelAndView setUpdate(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		return mv;
	}

	@PostMapping("update")
	public ModelAndView setUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionDTO.getId());
		int result = memberService.setUpdate(memberDTO);
		memberDTO.setName(sessionDTO.getName());
		session.setAttribute("member", memberDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}

	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/mypage");
		return mv;
	}

	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception {
		// 1. Session Attribute ?????????
		// session.removeAttribute("member");

		// 2. Session??? ????????? 0
		session.invalidate();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;

	}

	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception {
		// HttpSession session = request.getSession();

		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		if (memberDTO != null) {
			System.out.println("????????? ??????");
			session.setAttribute("member", memberDTO);
		} else {
			System.out.println("????????? ??????");
		}
		
		mv.addObject("dto", memberDTO);
		mv.setViewName("redirect:../");
		
		return mv;
	}

	@GetMapping("login")
	public ModelAndView login() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;

	}
	
	@GetMapping("idCheckAjax")
	public ModelAndView getIdCheckAjax(MemberDTO memberDTO)throws Exception{
		//?????? ????????? id ??????
		System.out.println(memberDTO.getId());
		memberDTO = memberService.getIdCheck(memberDTO);
		//1?????? ?????? ??????
		//0?????? ?????? ??????(??????)
		int result=0;
		if(memberDTO==null) {
			result=1;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}

	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id ?????? ??????");
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/idCheck");

		return mv;
	}

	@GetMapping("check")
	public ModelAndView check() throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/check");
		return mv;

	}

	@GetMapping("join")
	public String join() throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return "member/join";
	}

	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
				
		ModelAndView mv = new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, session);
		
		String message = "???????????? ??????";
		
		if(result>0) {
			message = "?????? ?????? ??????";
		} 
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");

		return mv;
	}

}
