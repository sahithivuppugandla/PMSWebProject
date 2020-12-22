package com.wellsfargo.batch5.pms.service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.BuyStockModel;


public interface BuyStockService {

	BuyStockModel add(BuyStockModel buyStock) throws PortfolioException;
}
