package com.inswave.wrm.reserve.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("reserveDao")
public interface ReserveDao {

	public List<Map> selectReserve(Map param);
}
