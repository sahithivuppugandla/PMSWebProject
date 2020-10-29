package com.wellsfargo.batch5.pms.model;

public class Company {
    private String comapanyCode;
    private String companyTitle;
    private String companyOperations;
    private Integer shareCount;
    private Double openSharePrice;
    private String sector;
    private String currency;
    private Double turnover;
    private Stock stock;
   
    public Company(){
   	 System.out.println("default constructor");
    }

    
	
	public Company(String comapanyCode, String companyTitle, String companyOperations, Integer shareCount,
			Double openSharePrice, String sector, String currency, Double turnover, Stock stock) {
		super();
		this.comapanyCode = comapanyCode;
		this.companyTitle = companyTitle;
		this.companyOperations = companyOperations;
		this.shareCount = shareCount;
		this.openSharePrice = openSharePrice;
		this.sector = sector;
		this.currency = currency;
		this.turnover = turnover;
		this.stock = stock;
	}



	public String getComapanyCode() {
		return comapanyCode;
	}

	public void setComapanyCode(String comapanyCode) {
		this.comapanyCode = comapanyCode;
	}

	public String getCompanyTitle() {
		return companyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	public String getCompanyOperations() {
		return companyOperations;
	}

	public void setCompanyOperations(String companyOperations) {
		this.companyOperations = companyOperations;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Double getOpenSharePrice() {
		return openSharePrice;
	}

	public void setOpenSharePrice(Double openSharePrice) {
		this.openSharePrice = openSharePrice;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	
	
	
}