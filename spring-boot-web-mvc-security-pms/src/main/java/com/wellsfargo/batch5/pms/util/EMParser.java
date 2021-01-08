package com.wellsfargo.batch5.pms.util;

import com.wellsfargo.batch5.pms.entity.BackOfficeUserEntity;
import com.wellsfargo.batch5.pms.entity.BuyStockEntity;
import com.wellsfargo.batch5.pms.entity.CommodityEntity;
import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.InvestorEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;
import com.wellsfargo.batch5.pms.model.BuyStockModel;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.RegisterBackOfficeUserModel;
import com.wellsfargo.batch5.pms.model.RegisterInvestorModel;
import com.wellsfargo.batch5.pms.model.StockModel;


public class EMParser {

	public static CompanyModel parse(CompanyEntity source) {
		CompanyModel target = new CompanyModel();
		
		target.setCompanyCode(source.getCompanyCode());
		target.setCompanyTitle(source.getCompanyTitle());
		target.setCompanyOperations(source.getCompanyOperations());
		target.setShareCount(source.getShareCount());
		target.setOpenSharePrice(source.getOpenSharePrice());
		target.setSector(source.getSector());
		target.setCurrency(source.getCurrency());
		target.setTurnover(source.getTurnover());
				
		return target;
	}
	
	public static StockModel parse(StockEntity source) {
		StockModel target = new StockModel();
		
		target.setStockId(source.getStockId());
		target.setStockExchange(source.getStockExchange());
		target.setCurrentPrice(source.getCurrentPrice());
		target.setDate(source.getDate());
		target.setTime(source.getTime());
		target.setCompany(parse(source.getCompany()));
		
		
		
		return target;
		
	}
	
	public static CompanyEntity parse(CompanyModel source) {
		
		CompanyEntity target = new CompanyEntity();
		
		target.setCompanyCode(source.getCompanyCode());
		target.setCompanyTitle(source.getCompanyTitle());
		target.setCompanyOperations(source.getCompanyOperations());
		target.setShareCount(source.getShareCount());
		target.setOpenSharePrice(source.getOpenSharePrice());
		target.setSector(source.getSector());
		target.setCurrency(source.getCurrency());
		target.setTurnover(source.getTurnover());
				
		return target;
	}
	
	public static StockEntity parse(StockModel source) {
		StockEntity target = new StockEntity();
		
		target.setStockId(source.getStockId());
		target.setStockExchange(source.getStockExchange());
		target.setCurrentPrice(source.getCurrentPrice());
		target.setDate(source.getDate());
		target.setTime(source.getTime());
		target.setCompany(parse(source.getCompany()));
		
		
		
		return target;
		
	}
	
	public static BackOfficeUserEntity parse(RegisterBackOfficeUserModel source) {
		BackOfficeUserEntity target = new BackOfficeUserEntity();
		
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setPassword(source.getPassword());
		target.setRole("BOR");
		target.setUserName(source.getUserName());
		
		return target;
	}
	
	public static InvestorEntity parse(RegisterInvestorModel source) {
		InvestorEntity target = new InvestorEntity();
		
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setMobileNumber(source.getMobileNumber());
		target.setEmail(source.getEmail());
		target.setAddress(source.getAddress());
		target.setPassword(source.getPassword());
		target.setRole("INVESTOR");
		target.setUserName(source.getUserName());
		
		return target;
	}
	
	public static BuyStockEntity parse(BuyStockModel source) {
		BuyStockEntity target = new BuyStockEntity();
		target.setCompany(parse(source.getCompany()));
		target.setShareCount(source.getShareCount());
		return target;
	}
	
	public static BuyStockModel parse(BuyStockEntity source) {
		BuyStockModel target = new BuyStockModel();
		target.setCompany(parse(source.getCompany()));
		target.setShareCount(source.getShareCount());
		return target;
	}
	
	public static CommodityModel parse(CommodityEntity source) {
		CommodityModel target = new CommodityModel();

		target.setItemName(source.getItemName());
		target.setItemPrice(source.getItemPrice());
		target.setUpdatedDate(source.getUpdatedDate());
		target.setUpdatedTime(source.getUpdatedTime());

		return target;
	}

	public static CommodityEntity parse(CommodityModel source) {

		CommodityEntity target = new CommodityEntity();

		target.setItemName(source.getItemName());
		target.setItemPrice(source.getItemPrice());
		target.setUpdatedDate(source.getUpdatedDate());
		target.setUpdatedTime(source.getUpdatedTime());

		return target;
	}
	
}
