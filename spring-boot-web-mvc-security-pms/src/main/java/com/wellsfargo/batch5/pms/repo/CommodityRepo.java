package com.wellsfargo.batch5.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.CommodityEntity;



@Repository
public interface CommodityRepo extends JpaRepository<CommodityEntity, Integer> {

	boolean existsByItemName(String itemName);
	CommodityEntity findByItemName(String itemName);
	CommodityEntity findCommByItemName(String itemName);
}
