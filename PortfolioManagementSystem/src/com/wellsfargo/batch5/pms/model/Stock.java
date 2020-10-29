package com.wellsfargo.batch5.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Stock {
	private String companyCode;
	private String stockExchange;
	private Double currentPrice;
	private LocalDate date;
	private LocalTime time;
	public Stock(){
		System.out.println("default constructor");
	}
	
	
	public Stock(String companyCode, String stockExchange, Double currentPrice, LocalDate date, LocalTime time) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}


	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	

	
}
