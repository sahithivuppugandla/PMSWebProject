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

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.exception.CustomerNotFoundException;
import com.iiht.training.eloan.service.CustomerService;
import com.iiht.training.eloan.service.ExceptionApi;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerClerk(@RequestBody @Valid UserDto userDto, BindingResult result)
			throws ExceptionResponse {

		ResponseEntity<UserDto> response = null;

		if (result.hasErrors()) {
			throw new ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.currentTimeMillis(),
					  HttpStatus.NOT_FOUND.value());

		} else {

			userDto = customerService.register(userDto);
			response = new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}

		return response;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> usersAction() throws ExceptionResponse{
		return new ResponseEntity<List<UserDto>>(customerService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/all-loans")
	public ResponseEntity<List<LoanDto>> loanAction() throws ExceptionResponse{
		return new ResponseEntity<List<LoanDto>>(customerService.getAllLoans(), HttpStatus.OK);
	}
	
	

	@PostMapping("/apply-loan/{customerId}")
	public ResponseEntity<LoanOutputDto> applyLoan(@PathVariable Long customerId,
												 @RequestBody @Valid LoanDto loanDto,BindingResult result) throws ExceptionResponse{
		ResponseEntity<LoanOutputDto> response = null;
		if(result.hasErrors()) {
			throw new ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.currentTimeMillis(),
					  HttpStatus.NOT_FOUND.value());
		}else {
			LoanOutputDto loanOutputDto= customerService.applyLoan(customerId,loanDto);
			response = new ResponseEntity<LoanOutputDto>(loanOutputDto, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/loan-status/{loanAppId}")
	public ResponseEntity<LoanOutputDto> getStatus(@PathVariable Long loanAppId){
		return new ResponseEntity<LoanOutputDto>(customerService.getStatus(loanAppId), HttpStatus.OK);
	}
	
	@GetMapping("/loan-status-all/{customerId}")
	public ResponseEntity<List<LoanOutputDto>> getStatusAll(@PathVariable Long customerId){
		return new ResponseEntity<List<LoanOutputDto>>(customerService.getStatusAll(customerId), HttpStatus.OK);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(CustomerNotFoundException ex){
		ExceptionResponse exception = 
				new ExceptionResponse(ex.getMessage(),
									  System.currentTimeMillis(),
									  HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response =
				new ResponseEntity<ExceptionResponse>(exception, HttpStatus.NOT_FOUND);
		return response;
	}
}
