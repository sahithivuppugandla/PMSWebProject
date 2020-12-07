package com.iiht.training.eloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.exception.AlreadyFinalizedException;
import com.iiht.training.eloan.exception.ManagerNotFoundException;
import com.iiht.training.eloan.service.ExceptionApi;
import com.iiht.training.eloan.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/all-processed")
	public ResponseEntity<List<LoanOutputDto>> allProcessedLoans() {
		return new ResponseEntity<List<LoanOutputDto>>(managerService.allProcessedLoans(), HttpStatus.OK);
	}
	
	@PostMapping("/reject-loan/{managerId}/{loanAppId}")
	public ResponseEntity<RejectDto> rejectLoan(@PathVariable Long managerId,
												@PathVariable Long loanAppId,
												@RequestBody RejectDto rejectDto){
		return new ResponseEntity<RejectDto>(managerService.rejectLoan(managerId, loanAppId, rejectDto),HttpStatus.OK);
	}
	
	
	/*
	 * @PostMapping("/reject-loan/{managerId}/{loanAppId}") public
	 * ResponseEntity<LoanOutputDto> rejectLoan(@PathVariable Long managerId,
	 * 
	 * @PathVariable Long loanAppId,
	 * 
	 * @RequestBody RejectDto rejectDto, BindingResult result) throws
	 * ExceptionResponse{ ResponseEntity<LoanOutputDto> response = null;
	 * if(result.hasErrors()) { throw new
	 * ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.
	 * currentTimeMillis(), HttpStatus.NOT_FOUND.value()); }else { response = new
	 * ResponseEntity<List<LoanOutputDto>>(managerService.rejectLoan(managerId,
	 * loanAppId, rejectDto), HttpStatus.OK); } return response; }
	 */
	
	@PostMapping("/sanction-loan/{managerId}/{loanAppId}")
	public ResponseEntity<SanctionOutputDto> sanctionLoan(@PathVariable Long managerId,
												@PathVariable Long loanAppId,
												@RequestBody SanctionDto sanctionDto, BindingResult result) throws ExceptionResponse{
		ResponseEntity<SanctionOutputDto> response = null;
		if(result.hasErrors()) {
			throw new ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.currentTimeMillis(),
					  HttpStatus.NOT_FOUND.value());
		}else {
			response = new ResponseEntity<SanctionOutputDto>(managerService.sanctionLoan(managerId, loanAppId, sanctionDto), HttpStatus.OK);
		}
		return response;
	}
	
	@ExceptionHandler(ManagerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(ManagerNotFoundException ex){
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(),
									  System.currentTimeMillis(),
									  HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response =
				new ResponseEntity<ExceptionResponse>(exception, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(AlreadyFinalizedException.class)
	public ResponseEntity<ExceptionResponse> handler(AlreadyFinalizedException ex){
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(),
									  System.currentTimeMillis(),
									  HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response =
				new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
		return response;
	}
}
