package com.inswave.wrm.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inswave.wrm.common.service.LoginService;
import com.inswave.wrm.common.service.MenuService;
import com.inswave.wrm.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InitController {
	
	private final MemberService service;
	
	private final LoginService loginService;
	
	private final MenuService menuService;

	/**
	 * 기본 Root Url 처리
	 * 
	 * @date 2017.12.22
	 * @author Inswave Systems
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String IndexBase(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("movePage", loginService.getLoginPage(request.getParameter("w2xPath")));
		return "websquare";
	}	
	
//	/**
//	 * 기본 Root Url 처리
//	 * 
//	 * @date 2017.12.22
//	 * @author Inswave Systems
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String IndexBase(HttpServletRequest request, Model model) throws Exception {
//		model.addAttribute("movePage", loginService.getLoginPage(request.getParameter("w2xPath")));
//		return "websquare/websquare";
//	}
	
	/**
	 * Popup Url 처리
	 * 
	 * @date 2017.12.22
	 * @author Inswave Systems
	 */
	@RequestMapping(value = "/popup", method = RequestMethod.GET)
	public String IndexWebSquare(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("movePage", loginService.getLoginPage(request.getParameter("w2xPath")));
		return "websquare/popup";
	}
}
