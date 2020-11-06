package com.iiht.evaluation.eloan.service;

import java.sql.SQLException;
import java.util.List;

import com.iiht.evaluation.eloan.model.LoanInfo;
import com.wellsfargo.batch5.pms.exception.LoanException;

public interface ILoanInfoService {
	LoanInfo apply(LoanInfo loan) throws LoanException, SQLException;
	LoanInfo save(LoanInfo loan) throws SQLException, LoanException;
	List<LoanInfo> listAll() throws LoanException;
	LoanInfo trackById(Integer applno) throws LoanException;
	Boolean updateStatus(Integer loanApplicationNum, String status) throws SQLException, LoanException;
}
