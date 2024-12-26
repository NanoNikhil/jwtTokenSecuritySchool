package com.school.service;

import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.entity.School;
import com.school.repository.SchoolRepository;
import com.school.service.SchoolUserDetails;

@Service
public class SchoolUserDetailService implements UserDetailsService{
	//Logger logger = LoggerFactory.getLogger(SchoolUserDetailService.class);
	
	
	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// logger.debug("Fetching user details for username: {}", username);
		Optional<School> student =schoolRepository.findByUsername(username);
		//logger.debug("Result: {}", student);

		 return
				 student
	                      .map(SchoolUserDetails::new)
	                        .orElseThrow(() -> new UsernameNotFoundException(username + " not found in system"));
	}

}
