package com.wellsfargo.batch5.pms.dao;

import java.util.List;

import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.Company;

public interface ICompanyDao {
	Company add(Company company) throws LibraryException;
	Company save(Company company)throws LibraryException;
	void remove(Integer companyCode) throws LibraryException;
	List<Company> listAll() throws LibraryException;
	Company getCompanyByID(Integer companyCode) throws LibraryException;
}
