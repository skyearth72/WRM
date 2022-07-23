package com.inswave.wrm.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.inswave.wrm.sample.dao.TemplateDao;
import com.inswave.wrm.sample.service.TemplateService;

import lombok.RequiredArgsConstructor;

@Service("templateService")
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {
	private final TemplateDao templateDao;

	public Map selectMemberInfoForTemplate(Map param) {
		return templateDao.selectMemberInfoForTemplate(param);
	}

	public List selectMemberFavoriteForTemplate(Map param) {
		return templateDao.selectMemberFavoriteForTemplate(param);
	}
}
