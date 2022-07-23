package com.inswave.wrm.reserve.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.inswave.wrm.reserve.dao.ReserveDao;
import com.inswave.wrm.reserve.service.ReserveService;

import lombok.RequiredArgsConstructor;

@Service("reserveService")
@RequiredArgsConstructor
public class ReserveServiceImpl implements ReserveService {

	private final ReserveDao reserveDao;
	
	/**
	 * 인사기본관리(개인기본정보)
	 * 
	 * @param param Client 전달한 데이터 맵 객체
	 */
	@Override
	public List<Map> selectReserve(Map param) {
		return reserveDao.selectReserve(param);
	}
}
