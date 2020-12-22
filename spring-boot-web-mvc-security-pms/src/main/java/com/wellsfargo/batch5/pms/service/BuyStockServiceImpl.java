package com.wellsfargo.batch5.pms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.BuyStockModel;
import com.wellsfargo.batch5.pms.repo.BuyStockRepo;
import com.wellsfargo.batch5.pms.util.EMParser;

@Service
public class BuyStockServiceImpl implements BuyStockService{

	@Autowired
	private BuyStockRepo buyStockRepo;
	
	@Transactional
	@Override
	public BuyStockModel add(BuyStockModel buyStock) throws PortfolioException {
		if(buyStock!=null)
		{
					
			buyStock = EMParser.parse(buyStockRepo.save(EMParser.parse(buyStock)));
		}
		return buyStock;
	}

}
