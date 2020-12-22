package com.wellsfargo.batch5.pms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.CommodityModel;
import com.wellsfargo.batch5.pms.repo.CommodityRepo;
import com.wellsfargo.batch5.pms.util.EMParser;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityRepo commRepo;

	@Transactional
	@Override
	public CommodityModel add(CommodityModel commodity) throws PortfolioException {
		if (commodity != null) {

			/*
			 * if (commRepo.findByItemName(commodity.getItemName())!=null) { throw new
			 * PortfolioException("Commodity " + commodity.getItemName() +
			 * " already exists"); }
			 */

			if (commRepo.existsByItemName(commodity.getItemName())) {
				throw new PortfolioException("Commodity " + commodity.getItemName() + " already exists");
			}
		
		commodity = EMParser.parse(commRepo.save(EMParser.parse(commodity)));
	}return commodity;

	}

	@Override
	public CommodityModel get(String commName) throws PortfolioException {
		if (!((commRepo.findByItemName(commName)) == null)) {
			throw new PortfolioException("Commodity " + commName + " does not exists");
		}

		return EMParser.parse(commRepo.findCommByItemName(commName));
	}

	@Override
	public List<CommodityModel> getAll() throws PortfolioException {
		return commRepo.findAll().stream().map(e -> EMParser.parse(e)).collect(Collectors.toList());
	}

}
