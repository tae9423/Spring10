package com.dg.s10.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dg.s10.board.BoardDTO;
import com.dg.s10.member.MemberDTO;

@Component("update")
public class BoardUpdateInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Map<String, Object> map = modelAndView.getModel();
		
		BoardDTO boardDTO = (BoardDTO)map.get("dto");
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		String id ="";
		
		if(memberDTO !=null) {
			id=memberDTO.getId();
		}
		
		if(!boardDTO.getWriter().equals(id)) {
			//1.redirect
			//modelAndView.setViewName("redirect:../member/login");
			//2. forward
			modelAndView.setViewName("common/result");
			modelAndView.addObject("msg", "작성자만 수정 가능");
			modelAndView.addObject("url", "./list");
			
		}
	}

}
