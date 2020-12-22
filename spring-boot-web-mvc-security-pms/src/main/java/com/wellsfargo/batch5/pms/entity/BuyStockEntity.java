package com.wellsfargo.batch5.pms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="buyStocks")
public class BuyStockEntity extends InvestorEntity  {

	@OneToMany(mappedBy="buyStock", cascade=CascadeType.ALL)
	private Set<StockEntity> stocks;
	
	@OneToMany(mappedBy="buyStock", cascade=CascadeType.ALL)
	private Set<CompanyEntity> company;
	
	@Column(name="sharecount")
	private Integer shareCount;

	
	public BuyStockEntity() {
		
	}

	public BuyStockEntity(Set<StockEntity> stocks, Set<CompanyEntity> company, Integer shareCount) {
		super();
		this.stocks = stocks;
		this.company = company;
		this.shareCount = shareCount;
	}

	public Set<StockEntity> getStocks() {
		return stocks;
	}

	public void setStocks(Set<StockEntity> stocks) {
		this.stocks = stocks;
	}

	public Set<CompanyEntity> getCompany() {
		return company;
	}

	public void setCompany(Set<CompanyEntity> company) {
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
		return "BuyStockEntity [stocks=" + stocks + ", company=" + company + ", shareCount=" + shareCount + "]";
	}
	
	
	
}
