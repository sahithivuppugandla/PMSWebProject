
package com.wellsfargo.batch5.pms.controller;

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
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.service.CommodityService;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
	@Autowired
	private CommodityService commService;

	@GetMapping
	public ModelAndView commodityAction() throws PortfolioException {
		return new ModelAndView("commodity/commodity-page", "commodity", commService.getAll());
	}

	@GetMapping("/new")
	public ModelAndView newCommodityAction() {
		ModelAndView mv = new ModelAndView("commodity/commodity-form-page", "commodity", new CommodityModel());
		mv.addObject("isNew", true);
		return mv;
	}

	@PostMapping("/add")
	public ModelAndView addCommodityAction(@ModelAttribute("commodity") @Valid CommodityModel commodity,
			BindingResult result) throws PortfolioException {
		ModelAndView mv = null;

		if (result.hasErrors()) {
			mv = new ModelAndView("commodity/commodity-form-page", "commodity", commodity);
			mv.addObject("isNew", true);
		} else {
			commService.add(commodity);
			mv = new ModelAndView("redirect:/commodity");
		}
		return mv;
	}

}
