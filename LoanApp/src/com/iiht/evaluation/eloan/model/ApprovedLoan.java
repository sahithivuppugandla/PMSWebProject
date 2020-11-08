package com.iiht.evaluation.eloan.model;

import java.time.LocalDate;

public class ApprovedLoan {
	Integer applno;
	Integer amotsanctioned;
	Integer loanterm;
	LocalDate psd;
	LocalDate lcd;
	Integer interestrate;
	Integer emi;
	
	public ApprovedLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovedLoan(Integer applno, Integer amotsanctioned, Integer loanterm, LocalDate psd, LocalDate lcd, Integer interestrate, Integer emi) {
		super();
		this.applno = applno;
		this.amotsanctioned = amotsanctioned;
		this.loanterm = loanterm;
		this.psd = psd;
		this.lcd = lcd;
		this.interestrate = interestrate;
		this.emi = emi;
	}

	public Integer getApplno() {
		return applno;
	}

	public void setApplno(Integer applno) {
		this.applno = applno;
	}

	public Integer getAmotsanctioned() {
		return amotsanctioned;
	}

	public void setAmotsanctioned(Integer amotsanctioned) {
		this.amotsanctioned = amotsanctioned;
	}

	public Integer getLoanterm() {
		return loanterm;
	}

	public void setLoanterm(Integer loanterm) {
		this.loanterm = loanterm;
	}

	public LocalDate getPsd() {
		return psd;
	}

	public void setPsd(LocalDate psd) {
		this.psd = psd;
	}

	public LocalDate getLcd() {
		return lcd;
	}

	public void setLcd(LocalDate localDate) {
		this.lcd = localDate;
	}
	
	public Integer getInterestRate() {
		return interestrate;
	}

	public void setInterestRate(Integer interestrate) {
		this.interestrate = interestrate;
	}

	public Integer getEmi() {
		return emi;
	}

	public void setEmi(Integer emi) {
		this.emi = emi;
	}

	@Override
	public String toString() {
		return "ApprovedLoan [applno=" + applno + ", amotsanctioned=" + amotsanctioned + ", loanterm=" + loanterm
				+ ", psd=" + psd + ", lcd=" + lcd + ", emi=" + emi + "]";
	}
	
	
}
