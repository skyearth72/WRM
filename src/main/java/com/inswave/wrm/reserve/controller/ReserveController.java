package com.inswave.wrm.reserve.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inswave.wrm.reserve.service.ReserveService;
import com.inswave.wrm.util.Result;

@Controller
public class ReserveController {
	
	@Resource(name = "reserveService")
	private ReserveService service;


	/**
	 * searchMemberBasic - 조회조건에 따른 인사기본관리 리스트를 조회한다.
	 * 
	 * @date 2017.12.22
	 * @param {} dma_search { TYPE:"사원명 또는 사원코드 또는 직위 또는 소속", CONTENTS:"검색어", IS_USE:"사용여부" }
	 * @returns mv dlt_memberBasic ( 인사기본관리 리스트 )
	 * @author Inswave Systems
	 * @example
	 */
	@RequestMapping("/reserve/searchReserve")
	public @ResponseBody Map<String, Object> searchReserve(@RequestBody Map<String, Object> param) {
		Result result = new Result();
		try {
			result.setData("dlt_memberBasic", service.selectReserve((Map) param.get("dma_search")));
			result.setStatusMsg(result.STATUS_SUCESS, "인사기본관리 리스트가 조회되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
			result.setMsg(result.STATUS_ERROR, "인사기본관리 리스트를 가져오는 도중 오류가 발생하였습니다.");
		}
		return result.getResult();
	}
}
