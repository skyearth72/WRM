package com.inswave.wrm.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.inswave.wrm.sample.dao.LargeDataDao;
import com.inswave.wrm.sample.dao.ZipCodeStreetDao;
import com.inswave.wrm.sample.service.ZipCodeService;

import lombok.RequiredArgsConstructor;

@Service("zipCodeService")
@RequiredArgsConstructor
public class ZipCodeServiceImpl implements ZipCodeService {

	private final LargeDataDao largeDataDao;

	private final ZipCodeStreetDao zipCodeStreetDao;

	@Override
	public List selectZipCodeStreet(Map param) {
		return largeDataDao.selectZipCodeStreet(param);
	}

	public Map selectZipCodeStreetByDefaultResultHandler(Map param) {
		return largeDataDao.selectZipCodeStreetByDefaultResultHandler(param);
	}

	public List selectZipCodeStreetByStreet(Map param) {
		return zipCodeStreetDao.selectZipCodeStreetByStreetPaging(param);
	}

	public int selectZipCodeStreetByStreetTotalCnt(Map param) {
		return zipCodeStreetDao.selectZipCodeStreetByStreetTotalCnt(param);
	}
}
