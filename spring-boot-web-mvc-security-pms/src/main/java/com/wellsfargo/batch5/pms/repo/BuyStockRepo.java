package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.BuyStockEntity;

@Repository
public interface BuyStockRepo extends JpaRepository<BuyStockEntity,Integer>{

}
