package com.payment.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping("/main/demo")  
public class DemoController {
	@RequestMapping("/demoMain")  
    public String toIndex(HttpServletRequest request,Model model){  
        //int userId = Integer.parseInt(request.getParameter("id"));  
        model.addAttribute("userId", "11");  
        return "main/demo/demoMain";  
    }  
}
