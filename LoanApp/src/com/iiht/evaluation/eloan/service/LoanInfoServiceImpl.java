package com.iiht.evaluation.eloan.service;

import java.sql.SQLException;
import java.util.List;

import com.iiht.evaluation.eloan.dao.ILoanInfoDao;
import com.iiht.evaluation.eloan.dao.LoanInfoImpl;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.wellsfargo.batch5.pms.exception.LoanException;


public class LoanInfoServiceImpl implements ILoanInfoService {

	private ILoanInfoDao loanDao;
	public LoanInfoServiceImpl() {
		this.loanDao = new LoanInfoImpl();
	}
		
	
	
	@Override
	public LoanInfo apply(LoanInfo loan) throws LoanException, SQLException {
		if(loan!=null) {
			loanDao.apply(loan);
		}
		return loan;
	}

	@Override
	public LoanInfo save(LoanInfo loan) throws SQLException, LoanException {
		if(loan!=null) {
			loanDao.save(loan);
		}
		return loan;
	}

	@Override
	public List<LoanInfo> listAll() throws LoanException {
		
		return loanDao.listAll();
	}

	@Override
	public LoanInfo trackById(Integer applno) throws LoanException {
		
		return loanDao.trackById(applno);
	}

	@Override
	public Boolean updateStatus(Integer loanApplicationNum, String status) throws SQLException, LoanException {
		return loanDao.updateStatus(loanApplicationNum, status);
	}

}
