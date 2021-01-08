package com.wellsfargo.batch5.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.PortfolioWalletEntity;


@Repository
public interface PortfolioWalletRepo extends JpaRepository<PortfolioWalletEntity, Integer> {

}


