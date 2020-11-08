package com.iiht.evaluation.eloan.dao;

import java.sql.SQLException;
import java.util.List;

import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.wellsfargo.batch5.pms.exception.LoanException;

public interface ILoanApprove {

	ApprovedLoan calemi(ApprovedLoan loan) throws LoanException, SQLException;
	List<ApprovedLoan> listAll() throws LoanException;
}
