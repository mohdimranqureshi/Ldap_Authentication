package com.xavient.ldapAuthentication.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xavient.ldapAuthentication.model.Employee;

import org.tempuri.AuthenticationSoap;


@Controller
public class MainController {

	@Autowired
	private AuthenticationSoap authenticationSoap;
	 
	
	@RequestMapping(value = "/login")
	public ModelAndView loginpage(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("login");                       
        return model;
	}
	
	
    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public ModelAndView doLogin(HttpServletRequest request,
    		@ModelAttribute("Employee") Employee employee) {

    	ModelAndView model = new ModelAndView();
    	
    	if(employee == null || employee.getUserName() == null ||  employee.getPassword() == null){
			
    		model.setViewName("login");
    		
		}else{
			
			boolean isValidUser = false;
			
			isValidUser = authenticationSoap.isAuthenticated(employee.getUserName(), employee.getPassword());
			
			if (isValidUser) {

				HttpSession session = request.getSession();
				session.setAttribute("SessionEmployee", employee);
				model.setViewName("home");
			}
				else{
					model.addObject("errorMessage", "Incorrect Username or Password");
					model.setViewName("login");
					
			}	
		}
		return model;
    }
} 