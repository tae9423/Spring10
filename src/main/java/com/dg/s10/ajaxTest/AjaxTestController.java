package com.dg.s10.ajaxTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ajax/*")
public class AjaxTestController {
	
	@GetMapping("t1")
	public ModelAndView t1(Integer num)throws Exception {
		System.out.println("t1 test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", "DG");
		return mv;
	}

}
