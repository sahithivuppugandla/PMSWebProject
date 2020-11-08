package com.iiht.evaluation.eloan.service;

import java.sql.SQLException;

import com.iiht.evaluation.eloan.dao.ILoanApprove;
import com.iiht.evaluation.eloan.dao.LoanApproveImpl;

import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.wellsfargo.batch5.pms.exception.LoanException;

public class LoanApproveServiceImpl implements ILoanApproveService {

	private ILoanApprove approveDao;
	public LoanApproveServiceImpl() {
		this.approveDao = new LoanApproveImpl();
	}
	
	@Override
	public ApprovedLoan calemi(ApprovedLoan loan) throws LoanException, SQLException {
		return approveDao.calemi(loan);
	}

}
