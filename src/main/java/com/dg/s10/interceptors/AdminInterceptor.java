package com.dg.s10.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dg.s10.member.MemberDTO;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//admin
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		boolean result = false;
		if(memberDTO != null && memberDTO.getId().equals("admin")) {
			result=true;
		}else {
			//1.redirect
			//response.sendRedirect("../member/login");
			//2.forward
			request.setAttribute("msg", "관리자만 가능");
			request.setAttribute("url", "../member/login");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("After Controller return");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("After View Randering");
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("비동기 요청시 postHandle과 afterCompletion 메서드를 수행하지 않고 이 메서드를 실행");
	}
	
	
}
