package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.wellsfargo.batch5.pms.exception.LoanException;

public class LoanInfoImpl implements ILoanInfoDao {

	public static final String INS_QRY = "INSERT INTO LoanApplication(loanName,loanAmt,loanAppDate,businessStructure,billingIndicator,taxIndicator,address,email,mobile) VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String UPD_QRY = "UPDATE LoanApplication SET loanName=?,loanAmt=?,loanAppDate=?,businessStructure=?,billingIndicator=?,taxIndicator=?,addres=?,email=?,mobile=? WHERE loanAppNum=?";

	public static final String UPD_STATUS_QRY = "UPDATE LoanApplication SET status=? WHERE loanAppNum=?";

	public static final String SELECT_ALL_QRY = "SELECT loanAppNum,loanName,loanAmt,loanAppDate,businessStructure,billingIndicator,taxIndicator,address,email,mobile,status FROM LoanApplication";
	public static final String SELECT_BY_ID_QRY = "SELECT loanAppNum,loanName,loanAmt,loanAppDate,businessStructure,billingIndicator,taxIndicator,address,email,mobile,statuss FROM LoanApplication WHERE loanAppNum=?";

	@Override
	public LoanInfo apply(LoanInfo loan) throws LoanException, SQLException {
		if (loan != null) {
			try (Connection con = ConnectionDao.connect(); PreparedStatement pst = con.prepareStatement(INS_QRY)) {

				pst.setString(1, loan.getPurpose());
				pst.setInt(2, loan.getAmtrequest());
				pst.setDate(3, Date.valueOf(loan.getDoa()));
				pst.setString(4, loan.getBstructure());
				pst.setString(5, loan.getBindicator());
				pst.setString(6, loan.getTindicator());
				pst.setString(7, loan.getAddress());
				pst.setString(8, loan.getEmail());
				pst.setString(9, loan.getMobile());

			}
		}
		return loan;
	}

	@Override
	public LoanInfo save(LoanInfo loan) throws SQLException, LoanException {
		if (loan != null) {
			boolean isSubmitted = true;
			if (loan.getStatus().equalsIgnoreCase("submitted")) {
				isSubmitted = false;
			}
			if (!isSubmitted) {
				try (Connection con = ConnectionDao.connect();
						PreparedStatement pst = con.prepareStatement(UPD_STATUS_QRY)) {

					pst.setString(1, loan.getPurpose());
					pst.setInt(2, loan.getAmtrequest());
					pst.setDate(3, Date.valueOf(loan.getDoa()));
					pst.setString(4, loan.getBstructure());
					pst.setString(5, loan.getBindicator());
					pst.setString(6, loan.getTindicator());
					pst.setString(7, loan.getAddress());
					pst.setString(8, loan.getEmail());
					pst.setString(9, loan.getMobile());
					pst.setInt(10, loan.getApplno());
					pst.executeUpdate();
				} catch (SQLException exp) {
					System.out.println(exp);
					throw new LoanException("Sorry! An Error Occured While Saving Data!");
				}

			}
		}
		return loan;

	}

	@Override
	public Boolean updateStatus(Integer loanApplicationNum, String status) throws SQLException, LoanException {
		boolean statusUpdated=false;
		if (loanApplicationNum != null) {
			
			try (Connection con = ConnectionDao.connect(); PreparedStatement pst = con.prepareStatement(UPD_QRY)) {

				pst.setString(1, status);
				pst.setInt(2, loanApplicationNum);

				int rs= pst.executeUpdate();
				if(rs>0) {
					statusUpdated=true;
				}
			} catch (SQLException exp) {
				System.out.println(exp);
				throw new LoanException("Sorry! An Error Occured While Saving Data!");
			}

		}
		return statusUpdated;

	}

	@Override
	public List<LoanInfo> listAll() throws LoanException {
		List<LoanInfo> loans = new ArrayList<>();
		try (Connection con = ConnectionDao.connect(); PreparedStatement pst = con.prepareStatement(SELECT_ALL_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				LoanInfo loan = new LoanInfo();
				loan.setApplno(rs.getInt(1));
				loan.setPurpose(rs.getString(2));
				loan.setAmtrequest(rs.getInt(3));
				loan.setDoa(rs.getDate(4).toLocalDate());
				loan.setBstructure(rs.getString(5));
				loan.setBindicator(rs.getString(6));
				loan.setTindicator(rs.getString(7));
				loan.setAddress(rs.getString(8));
				loan.setEmail(rs.getString(9));
				loan.setMobile(rs.getString(10));
				loan.setStatus(rs.getString(11));

				loans.add(loan);
			}

		} catch (SQLException exp) {
			System.out.println(exp);
			throw new LoanException("Sorry! An Error Occured While Fetching Data!");
		}
		return loans;
	}

	@Override
	public LoanInfo trackById(Integer loanAppNum) throws LoanException {

		LoanInfo loan = null;
		try (Connection con = ConnectionDao.connect(); PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QRY)) {

			pst.setInt(1, loanAppNum);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				loan = new LoanInfo();
				loan.setApplno(rs.getInt(1));
				loan.setPurpose(rs.getString(2));
				loan.setAmtrequest(rs.getInt(3));
				loan.setDoa(rs.getDate(4).toLocalDate());
				loan.setBstructure(rs.getString(5));
				loan.setBindicator(rs.getString(6));
				loan.setTindicator(rs.getString(7));
				loan.setAddress(rs.getString(8));
				loan.setEmail(rs.getString(9));
				loan.setMobile(rs.getString(10));
				loan.setStatus(rs.getString(11));
			}
		} catch (SQLException exp) {
			System.out.println(exp);
			throw new LoanException("Something went wrong while fetching data");

		}
		return loan;
	}
}
