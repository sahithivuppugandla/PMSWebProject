package com.iiht.training.eloan.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.exception.AlreadyProcessedException;
import com.iiht.training.eloan.exception.ClerkNotFoundException;
import com.iiht.training.eloan.service.ClerkService;
import com.iiht.training.eloan.service.ExceptionApi;

@RestController
@RequestMapping("/clerk")
public class ClerkController {
	
	@Autowired
	private ClerkService clerkService;
	
	@GetMapping("/all-applied")
	public ResponseEntity<List<LoanOutputDto>> allAppliedLoans() {
		return new ResponseEntity<List<LoanOutputDto>>(clerkService.allAppliedLoans(), HttpStatus.OK);
	}
	
	@PostMapping("/process/{clerkId}/{loanAppId}")
	public ResponseEntity<ProcessingDto> processLoan(@PathVariable Long clerkId,
													 @PathVariable Long loanAppId,
													 @RequestBody @Valid ProcessingDto processingDto, BindingResult result) throws ExceptionResponse {
		ResponseEntity<ProcessingDto> response = null;
		if(result.hasErrors()) {
			throw new ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.currentTimeMillis(),
					  HttpStatus.NOT_FOUND.value());
		}else {
			response = new ResponseEntity<ProcessingDto>(clerkService.processLoan(clerkId, loanAppId, processingDto), HttpStatus.OK);
		}
		return response;
		
	}
	@ExceptionHandler(ClerkNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(ClerkNotFoundException ex){
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(),
									  System.currentTimeMillis(),
									  HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response =
				new ResponseEntity<ExceptionResponse>(exception, HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(AlreadyProcessedException.class)
	public ResponseEntity<ExceptionResponse> handler(AlreadyProcessedException ex){
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(),
									  System.currentTimeMillis(),
									  HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response =
				new ResponseEntity<ExceptionResponse>(exception, HttpStatus.BAD_REQUEST);
		return response;
	}
}
