package com.iiht.evaluation.eloan.dao;

import java.sql.SQLException;

import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.wellsfargo.batch5.pms.exception.LoanException;

public interface ILoanApprove {

	ApprovedLoan calemi(ApprovedLoan loan) throws LoanException, SQLException;
}
