package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BuyStockModel {

	

		
	private CompanyModel company;
	
	@NotNull(message="Share count is mandate")
	@Min(value=1,message="Share count can not be negative or zero")
	private Integer shareCount;

	public BuyStockModel() {
		
	}


	public BuyStockModel(CompanyModel company,
			Integer shareCount) {
		super();
	
		this.company = company;
		this.shareCount = shareCount;
	}


	public CompanyModel getCompany() {
		return company;
	}


	public void setCompany(CompanyModel company) {
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
		return "BuyStockModel [company=" + company + ", shareCount=" + shareCount + "]";
	}
	
	
}
