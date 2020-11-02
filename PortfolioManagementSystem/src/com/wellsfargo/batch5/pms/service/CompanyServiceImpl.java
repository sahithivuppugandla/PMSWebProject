package com.wellsfargo.batch5.pms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.batch5.pms.dao.CompanyDAOImpl;
import com.wellsfargo.batch5.pms.dao.ICompanyDao;
import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.Company;

public class CompanyServiceImpl implements ICompanyService {

	private ICompanyDao companyDao;

	public CompanyServiceImpl() {
		this.companyDao = new CompanyDAOImpl();
	}

	private boolean isValidCompanyCode(int companyCode) {
		return companyCode > 0;
	}

	private boolean isValidCompanyTitle(String title) {
		return title != null && title.length() >= 2 && title.length() <= 50;
	}

	private boolean isValidCompanyOperations(String operations) {
		return operations != null && operations.length() >= 2 && operations.length() <= 50;
	}

	private boolean isValidCompanyShareCount(int shareCount) {
		return shareCount > 0;
	}

	private boolean isValidSharePrice(double price) {
		return price >= 0;
	}

	private boolean isValidCompanySector(String sector) {
		return sector != null && sector.length() >= 2 && sector.length() <= 50;
	}

	private boolean isValidCurrency(String currency) {
		return currency != null && currency.length() >= 2 && currency.length() <= 50;
	}

	private boolean isValidCompanyTurnover(int turnover) {
		return turnover > 0;
	}

	private void validateCompany(Company company) throws LibraryException {
		List<String> errMsgs = new ArrayList<String>();

		if (!isValidCompanyCode(company.getCompanyCode())) {
			errMsgs.add("Company code cannot be null");
		}
		if (!isValidCompanyTitle(company.getCompanyTitle())) {
			errMsgs.add("Company Title can not be left blank and must be of 2 to 50 chars in length");
		}
		if (!isValidCompanyOperations(company.getCompanyOperations())) {
			errMsgs.add("Company Operations can not be left blank");
		}
		if (!isValidCompanyShareCount(company.getShareCount())) {
			errMsgs.add("Company share count cannot be null");
		}
		if (!isValidSharePrice(company.getOpenSharePrice())) {
			errMsgs.add("Company share price cannot be null");
		}

		if (!isValidCompanySector(company.getSector())) {
			errMsgs.add("Company sector cannot be null");
		}
		if (!isValidCurrency(company.getCurrency())) {
			errMsgs.add("Currency cannot be null");
		}
		if (!isValidCompanyTurnover(company.getTurnover())) {
			errMsgs.add("Company Turnover cannot be null");
		}

		if (!errMsgs.isEmpty()) {
			throw new LibraryException(errMsgs.toString());
		}

	}

	@Override
	public Company add(Company company) throws LibraryException {
		if (company != null) {
			validateCompany(company);
			companyDao.add(company);
		}
		return company;
	}

	@Override
	public Company save(Company company) throws LibraryException {
		if (company != null) {
			validateCompany(company);
			companyDao.save(company);
		}
		return company;
	}

	@Override
	public void remove(Integer companyCode) throws LibraryException {
		companyDao.remove(companyCode);
	}

	@Override
	public List<Company> listAll() throws LibraryException {
		return companyDao.listAll();
	}

	@Override
	public Company getCompanyByID(Integer companyCode) throws LibraryException {
		return companyDao.getCompanyByID(companyCode);
	}

}
