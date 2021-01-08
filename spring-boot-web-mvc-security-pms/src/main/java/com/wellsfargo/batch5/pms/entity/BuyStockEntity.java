package com.wellsfargo.batch5.pms.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="buyStocks")
public class BuyStockEntity extends InvestorEntity  {

	
	@ManyToOne
	@JoinColumn(name="comp_code")
	private CompanyEntity company;
	
	@Column(name="sharecount")
	private Integer shareCount;

	
	public BuyStockEntity() {
		
	}

	public BuyStockEntity(Integer shareCount, CompanyEntity company) {
		super();
		this.shareCount = shareCount;
		this.company=company;
	}

	

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
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
		return "BuyStockEntity [company=" + company + ", shareCount=" + shareCount + "]";
	}
	
	
	
}
