package com.iiht.training.eloan.service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.Users;

public class EMParser {

	public static LoanDto parse(Loan source) {
		LoanDto target = new LoanDto();
		
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		
		return target;
	}
	
	public static LoanOutputDto parseop(Loan source) {
		LoanOutputDto target = new LoanOutputDto();
		
		target.setLoanAppId(source.getId());
		target.setCustomerId(source.getCustomerId());
		target.setRemark(source.getRemark());
		target.setStatus(source.getStatus());
			
		return target;
	}
	
	public static Loan parse(LoanDto source)
	{
		Loan target = new Loan();
		
		/*
		 * target.setId(source1.getLoanAppId());
		 * target.setCustomerId(source1.getCustomerId());
		 * target.setStatus(source1.getStatus()); target.setRemark(source1.getRemark());
		 */
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		
		return target;
		
	}
	

	public static Users parse(UserDto source) {
		Users target = new Users();
		
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
				
		return target;
	}
	
	public static UserDto parse(Users source) {
		UserDto target = new UserDto();
		
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		return target;
	}
}
