package com.iiht.training.eloan.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.exception.LoanNotFoundException;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.EMParser;
import com.iiht.training.eloan.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Override
	public List<LoanOutputDto> allProcessedLoans() {
		return loanRepository.findAllProcessedLoan().stream().map(e->EMParser.parseop(e)).collect(Collectors.toList());
	}

	
	@Override
	public LoanOutputDto rejectLoan(Long managerId, Long loanAppId, RejectDto rejectDto) {
		LoanOutputDto loanOutputDto= new LoanOutputDto();
		if(rejectDto!=null) {
			if(!loanRepository.existsById(loanAppId)) {
				throw new LoanNotFoundException("Loan" + loanAppId + "  does not exists");
			}
			loanOutputDto=EMParser.parseop(loanRepository.rejectLoan(loanAppId));
			
		}
		  return loanOutputDto;
	}
	
	/*
	 * @Transactional
	 * 
	 * @Override public List<LoanOutputDto> rejectLoan(Long managerId, Long
	 * loanAppId, RejectDto rejectDto) {
	 * 
	 * 
	 * return loanRepository.rejectLoan(loanAppId,rejectDto.getRemark())
	 * .stream().map(e->EMParser.parseop(e)).collect(Collectors.toList());
	 * 
	 * }
	 */

	@Transactional
	@Override
	public SanctionOutputDto sanctionLoan(Long managerId, Long loanAppId, SanctionDto sanctionDto) {
		if(sanctionDto!=null) {
			if(!loanRepository.existsById(loanAppId)) {
				throw new LoanNotFoundException("Loan" + loanAppId + "  does not exists");
			}
			/*
			 * if (!loanRepository.existsById(clerkId)) { throw new
			 * ClerkNotFoundException("Clerk" + clerkId + "  does not exists"); }
			 */
			
			sanctionDto = EMParser.parse(sanctionInfoRepository.save(EMParser.parse(sanctionDto,managerId,loanAppId)));
			
		}
		Integer interestRate=10;
		LocalDate loanClosureDate=LocalDate.now().plusMonths(Integer.parseInt(sanctionDto.getPaymentStartDate()));
		int term = (sanctionDto.getLoanAmountSanctioned())*(1 + interestRate/100)^(sanctionDto.getTermOfLoan());
		double emi = term/(sanctionDto.getTermOfLoan());
		
		SanctionOutputDto sanctionOutputDto = new SanctionOutputDto();
		sanctionOutputDto= EMParser.parseop(sanctionInfoRepository.save(EMParser.parse(sanctionDto,managerId,loanAppId,loanClosureDate,emi)));
		return sanctionOutputDto;
	}

}
