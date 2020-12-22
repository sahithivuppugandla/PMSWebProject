package com.wellsfargo.batch5.pms.service;

import java.util.List;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommodityModel;

public interface CommodityService {

	CommodityModel add(CommodityModel stock) throws PortfolioException;

	CommodityModel get(String commName) throws PortfolioException;

	List<CommodityModel> getAll() throws PortfolioException;

}
