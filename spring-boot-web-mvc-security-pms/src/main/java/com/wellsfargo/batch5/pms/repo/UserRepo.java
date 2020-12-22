package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.LoginEntity;

@Repository
public interface UserRepo extends JpaRepository<LoginEntity, Integer> {

	boolean existsByUserName(String userName);
	LoginEntity findByUserName(String userName);
}
