package com.wellsfargo.batch5.pms.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.pms.entity.LoginEntity;
import com.wellsfargo.batch5.pms.exception.PortfolioException;
import com.wellsfargo.batch5.pms.model.RegisterBackOfficeUserModel;
import com.wellsfargo.batch5.pms.model.RegisterInvestorModel;
import com.wellsfargo.batch5.pms.repo.UserRepo;
import com.wellsfargo.batch5.pms.util.EMParser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = null;
		
		if(!userRepo.existsByUserName(username)) {
			throw new UsernameNotFoundException("Invalid user credentials!");
		}	
		
		LoginEntity loginUser = userRepo.findByUserName(username);
		
		user = (UserDetails) new User(loginUser.getUserName(), loginUser.getPassword(), 
					Collections.singletonList(new SimpleGrantedAuthority(loginUser.getRole()))
				);
		
		return user;
	}

	public void registerBORMember(RegisterBackOfficeUserModel borMember) throws PortfolioException {
		if(borMember!=null) {
			if(borMember.getPassword().equals(borMember.getConfirmPassword())) {
				borMember.setPassword(encoder.encode(borMember.getPassword()));
				userRepo.save(EMParser.parse(borMember));
			}else {
				throw new PortfolioException("Password do not match");
			}
		}	
	}
	
	public void registerInvestor(RegisterInvestorModel investor) throws PortfolioException {
		if(investor!=null) {
			if(investor.getPassword().equals(investor.getConfirmPassword())) {
				investor.setPassword(encoder.encode(investor.getPassword()));
				userRepo.save(EMParser.parse(investor));
			}else {
				throw new PortfolioException("Password do not match");
			}
		}
	}
}

