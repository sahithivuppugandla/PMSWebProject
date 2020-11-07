package com.iiht.evaluation.eloan.service;

import java.sql.SQLException;

import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.wellsfargo.batch5.pms.exception.LoanException;

public interface ILoanApproveService {

	ApprovedLoan calemi(ApprovedLoan loan) throws LoanException, SQLException;
}
