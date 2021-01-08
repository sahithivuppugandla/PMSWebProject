package com.wellsfargo.batch5.pms.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name="portfoliowallet")
public class PortfolioWalletEntity extends InvestorEntity{

	
	@Id
	@GeneratedValue
	@Column(name="wallet_id")
	private Integer walletId;
	
	
	@Column(name="wallet_balance")
	private Double walletBalance;
	
	@Column(name="amount_withdrawn")
	private Double amountWithdrawn;
	
	@OneToOne(mappedBy="wallet")
	private InvestorEntity walletHolder;
	
	public PortfolioWalletEntity() {
		
	}

	public PortfolioWalletEntity(Integer walletId,Double walletBalance, Double amountWithdrawn,InvestorEntity walletHolder) {
		super();
		this.walletId= walletId;
		this.walletBalance = walletBalance;
		this.amountWithdrawn = amountWithdrawn;
		this.walletHolder=walletHolder;
	}
	
	public Double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}
	
	public Double getAmountWithdrawn() {
		return amountWithdrawn;
	}
	public void setAmountWithdrawn(Double amountWithdrawn) {
		this.amountWithdrawn = amountWithdrawn;
	}

	
	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public InvestorEntity getWalletHolder() {
		return walletHolder;
	}

	public void setWalletHolder(InvestorEntity walletHolder) {
		this.walletHolder = walletHolder;
	}

	@Override
	public String toString() {
		return "PortfolioWalletEntity [walletBalance=" + walletBalance + ", amountWithdrawn=" + amountWithdrawn + "]";
	}

	
	
}

