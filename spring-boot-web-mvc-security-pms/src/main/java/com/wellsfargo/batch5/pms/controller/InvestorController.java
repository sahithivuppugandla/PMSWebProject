package com.wellsfargo.batch5.pms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.BuyStockModel;
import com.wellsfargo.batch5.pms.model.CompanyModel;
import com.wellsfargo.batch5.pms.model.PortfolioWalletModel;
import com.wellsfargo.batch5.pms.service.BuyStockService;
import com.wellsfargo.batch5.pms.service.CompanyService;

@Controller
@RequestMapping("/investor")
public class InvestorController {

	@Autowired
	private BuyStockService buyStockService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/new")
	public ModelAndView newBuyStockAction() {
		ModelAndView mv = new ModelAndView("investor/buy-stock-page","buyStock",new BuyStockModel());
		
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addStocksBoughtAction(
			@ModelAttribute("buyStock") @Valid BuyStockModel buyStock,
			BindingResult result) throws PortfolioException {
		ModelAndView mv=null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("investor/buy-stock-page","buyStock",buyStock);	
			
		}else {
			buyStockService.add(buyStock);
			mv = new ModelAndView("redirect:/investor");
		}
		return mv;
	}
	
	@ModelAttribute("companies")
	public List<CompanyModel> allCompanies() throws PortfolioException{
		return companyService.getAll();
	}
	
	
	@ModelAttribute("wallet")
	public List<PortfolioWalletModel> walletBalance() throws PortfolioException{
		return companyService.getAll();
	}
	
}
