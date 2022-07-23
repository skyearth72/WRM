package com.inswave.wrm.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inswave.wrm.sample.dao.EduDao;
import com.inswave.wrm.sample.service.EduService;

import lombok.RequiredArgsConstructor;

@Service("eduService")
@RequiredArgsConstructor
public class EduServiceImpl implements EduService {
	private final EduDao eduDao;

	
	@Transactional(value="dbTransactionManager", propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
	public int insertSpMember(Map param) throws Exception {
		return eduDao.insertSpMember(param);
	}

	@Transactional(value="dbTransactionManager", propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
	public int updateSpMember(Map param) throws Exception {
		return eduDao.updateSpMember(param);
	}

	public Map selectOneSpMember(Map param) throws Exception {
		return eduDao.selectOneSpMember(param);
	}

	public List selectListSpMember(Map param) throws Exception {
		return eduDao.selectListSpMember(param);
	}

	public Map selectListSpMemberByHandler(Map param) throws Exception {
		return eduDao.selectListSpMemberByHandler(param);
	}

	/**
	 * 우편번호 조회 where town = #{town}
	 */
	public List selectListZipCodeByTown(Map param) throws Exception {
		return eduDao.selectListZipCodeByTown(param);
	}

}
