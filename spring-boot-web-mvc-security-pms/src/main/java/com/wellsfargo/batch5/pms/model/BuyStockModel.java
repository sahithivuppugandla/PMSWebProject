package com.wellsfargo.batch5.pms.model;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.wellsfargo.batch5.pms.entity.CompanyEntity;
import com.wellsfargo.batch5.pms.entity.StockEntity;

public class BuyStockModel {

	
	private Set<StockModel> stocks;
		
	private Set<CompanyModel> company;
	
	@NotNull(message="Share count is mandate")
	@Min(value=1,message="Share count can not be negative or zero")
	private Integer shareCount;

	public BuyStockModel() {
		
	}


	public BuyStockModel(Set<StockModel> stocks, Set<CompanyModel> company,
			Integer shareCount) {
		super();
		this.stocks = stocks;
		this.company = company;
		this.shareCount = shareCount;
	}


	public Set<StockModel> getStocks() {
		return stocks;
	}


	public void setStocks(Set<StockModel> stocks) {
		this.stocks = stocks;
	}


	public Set<CompanyModel> getCompany() {
		return company;
	}


	public void setCompany(Set<CompanyModel> company) {
		this.company = company;
	}


	public Integer getShareCount() {
		return shareCount;
	}


	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}


	@Override
	public String toString() {
		return "BuyStockModel [stocks=" + stocks + ", company=" + company + ", shareCount=" + shareCount + "]";
	}
	
	
}
