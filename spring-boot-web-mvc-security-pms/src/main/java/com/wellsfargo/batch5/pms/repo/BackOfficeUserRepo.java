package com.wellsfargo.batch5.pms.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.pms.entity.BackOfficeUserEntity;
@Repository
public interface BackOfficeUserRepo extends JpaRepository<BackOfficeUserEntity,Integer> {
	boolean existsByUserName(String userName);
	BackOfficeUserEntity findByUserName(String userName);
}
