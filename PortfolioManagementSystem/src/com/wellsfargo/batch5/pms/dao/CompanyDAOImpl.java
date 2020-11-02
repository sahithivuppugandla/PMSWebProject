package com.wellsfargo.batch5.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.Company;

public class CompanyDAOImpl implements ICompanyDao {
	Logger log = Logger.getLogger("DAO");

	public static final String INS_QRY = "INSERT INTO companyIPO(company_code,company_title,operations,share_count,open_share_price,sector,currency,turnover) VALUES(?,?,?,?,?,?,?,?)";
	public static final String UPD_QRY = "UPDATE TABLE companyIPO SET share_count=?,open_share_price=?,turnover=? WHERE company_code=?";
	public static final String DEL_QRY = "DELETE FROM companyIPO WHERE company_code=?";
	public static final String SELECT_ALL_QRY = "SELECT company_code,company_title,operations,share_count,open_share_price,sector,currency,turnover FROM companyIPO";
	public static final String SELECT_BY_QRY = "SELECT company_code,company_title,operations,share_count,open_share_price,sector,currency,turnover FROM companyIPO WHERE company_code=? ";

	@Override
	public Company add(Company company) throws LibraryException {
		if (company != null) {
			try (Connection con = ConnectionProvider.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_QRY)) {

				pst.setInt(1, company.getCompanyCode());
				pst.setString(2, company.getCompanyTitle());
				pst.setString(3, company.getCompanyOperations());
				pst.setInt(4, company.getShareCount());
				pst.setDouble(5, company.getOpenSharePrice());
				pst.setString(6, company.getSector());
				pst.setString(7, company.getCurrency());
				pst.setInt(8, company.getTurnover());

				pst.executeUpdate();
			} catch (SQLException exp) {
				log.error(exp);
				throw new LibraryException("Sorry! An Error Occured While Saving Data!");
			}
		}
		return company;
	}

	@Override
	public Company save(Company company) throws LibraryException {
		if (company != null) {
			try (Connection con = ConnectionProvider.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_QRY)) {
				pst.setInt(1, company.getShareCount());
				pst.setDouble(2, company.getOpenSharePrice());
				pst.setInt(3, company.getTurnover());
				pst.setInt(4, company.getCompanyCode());

				pst.executeUpdate();
			} catch (SQLException exp) {
				log.error(exp);
				throw new LibraryException("Sorry! An Error Occured While Saving Data!");
			}
		}
		return company;
	}

	@Override
	public void remove(Integer companyCode) throws LibraryException {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_QRY)) {

			pst.setInt(1, companyCode);

			pst.executeUpdate();
		} catch (SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Deleting Data!");
		}

	}

	@Override
	public List<Company> listAll() throws LibraryException {
		List<Company> company = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_ALL_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Company comp = new Company();

				comp.setCompanyCode(rs.getInt(1));
				comp.setCompanyTitle(rs.getString(2));
				comp.setCompanyOperations(rs.getString(3));
				comp.setShareCount(rs.getInt(4));
				comp.setOpenSharePrice(rs.getDouble(5));
				comp.setSector(rs.getString(6));
				comp.setCurrency(rs.getString(7));
				comp.setTurnover(rs.getInt(8));

				company.add(comp);
			}

		} catch (SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Fetching Data!");
		}
		return company;
	}

	@Override
	public Company getCompanyByID(Integer companyCode) throws LibraryException {
		Company comp = null;
		Boolean status = false;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_BY_QRY)) {
			System.out.println("Entering getByUserDetails method");
			pst.setInt(1, companyCode);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				comp = new Company();

				comp.setCompanyCode(rs.getInt(1));
				comp.setCompanyTitle(rs.getString(2));
				comp.setCompanyOperations(rs.getString(3));
				comp.setShareCount(rs.getInt(4));
				comp.setOpenSharePrice(rs.getDouble(5));
				comp.setSector(rs.getString(6));
				comp.setCurrency(rs.getString(7));
				comp.setTurnover(rs.getInt(8));

			}
		} catch (SQLException exp) {
			log.error(exp);
			exp.printStackTrace();
			throw new LibraryException("Sorry! An Error Occured While Fetching Data!");
		}
		return comp;
	}

}
