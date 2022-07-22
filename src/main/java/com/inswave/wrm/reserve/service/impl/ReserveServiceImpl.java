package com.inswave.wrm.reserve.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.inswave.wrm.reserve.dao.ReserveDao;
import com.inswave.wrm.reserve.service.ReserveService;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService {

	@Resource(name = "reserveDao")
	private ReserveDao reserveDao;
	
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;



	/**
	 * 대용량 정보 조회시 필요합니다.
	 */
	@Autowired
	private SqlSession sqlsession;

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
