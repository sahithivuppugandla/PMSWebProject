package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.wellsfargo.batch5.pms.exception.LoanException;

public class LoanApproveImpl implements ILoanApprove {

	public static final String INS_QRY = "INSERT INTO LoanSanctioned(loanAppNum,loanAmtSanctioned,loanTerm,payStartDate,loanClosureDate,interestRate,emi) VALUES(?,?,?,?,?,?,?)";
	public static final String SELECT_ALL_QRY = "SELECT loanAppNum,loanAmtSanctioned,loanTerm,payStartDate,loanClosureDate,interestRate,emi FROM LoanSanctioned";
	
	@Override
	public ApprovedLoan calemi(ApprovedLoan loan) throws LoanException, SQLException {
		if(loan!=null) {
			try (Connection con = ConnectionDao.connect();
					PreparedStatement pst = con.prepareStatement(INS_QRY)){
				pst.setInt(1, loan.getApplno());
				pst.setInt(2, loan.getAmotsanctioned());
				pst.setInt(3, loan.getLoanterm());
				pst.setDate(4,  Date.valueOf(loan.getPsd()));
				pst.setDate(5,  Date.valueOf(loan.getLcd()));
				pst.setInt(6, loan.getInterestrate());
				pst.setInt(7, loan.getEmi());
				
				pst.executeUpdate();
			}catch(SQLException exp) {
				System.out.println(exp);
				throw new LoanException("Sorry! An Error Occured While Adding Data!");
		}
		
		
		
	}
	
	return loan;
}
	@Override
	public List<ApprovedLoan> listAll() throws LoanException {
		List<ApprovedLoan> loans = new ArrayList<>();
		try (Connection con = ConnectionDao.connect(); PreparedStatement pst = con.prepareStatement(SELECT_ALL_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				ApprovedLoan loan = new ApprovedLoan();
				loan.setApplno(rs.getInt(1));
				loan.setAmotsanctioned(rs.getInt(2));
				loan.setLoanterm(rs.getInt(3));
				loan.setPsd(rs.getDate(4).toLocalDate());
				loan.setLcd(rs.getDate(5).toLocalDate());
				loan.setInterestrate(rs.getInt(6));
				loan.setEmi(rs.getInt(7));
				

				loans.add(loan);
			}

		} catch (SQLException exp) {
			System.out.println(exp);
			throw new LoanException("Sorry! An Error Occured While Fetching Data!");
		}
		return loans;
	}
}