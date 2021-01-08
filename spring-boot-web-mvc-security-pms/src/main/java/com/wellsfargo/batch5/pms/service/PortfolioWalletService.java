package com.wellsfargo.batch5.pms.service;

import java.util.List;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.PortfolioWalletModel;

public interface PortfolioWalletService {

	
	PortfolioWalletModel get(Integer walletId) throws PortfolioException;

	
}
