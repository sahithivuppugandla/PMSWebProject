package com.wellsfargo.batch5.pms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.SuperUserEntity;

@Repository
public interface SuperUserRepo extends JpaRepository<SuperUserEntity, Integer>{
	boolean existsByUserName(String userName);
	SuperUserEntity findByUserName(String userName);
}
