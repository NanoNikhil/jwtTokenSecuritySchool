package com.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.school.dto.AuthRequest;
import com.school.dto.RequestDto;
import com.school.entity.School;
import com.school.service.JwtService;
import com.school.service.SchoolService;

@RestController
public class SchoolContoller {

	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
//	
//	//To generate a token
//	@PostMapping("/authenticate")
//    public String authenticate(@RequestBody AuthRequest authRequest) {
//		
//		return jwtService.generateToken(authRequest.getUsername());
//    }
//	
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthRequest authRequest) {

		
		/* return jwtService.generateToken(authRequest.getUsername()); */

		
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("Authentication Failed!");
		}

	}
	@PostMapping("/school")
	public School createSchool(@RequestBody RequestDto requestDto) {
		return schoolService.createSchool(requestDto);
	}
	
	@PostMapping("/schools")
	public List<School> createSchools(@RequestBody List<RequestDto> requestDtos) {
		return schoolService.createMembers(requestDtos);
	}
	
	@GetMapping("/school/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_TEACHER')")
	public School findWithId(@PathVariable Long id) {
		return schoolService.findUsingId(id);
	}
	
	@GetMapping("/schools")
	public List<School> findSchhoolAll() {
		return schoolService.getUsingAll();
	}
	
	@PutMapping("/school/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_TEACHER')")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
	public School update(@PathVariable Long id,@RequestBody RequestDto requestDto) {
		return schoolService.updateSchool(id,requestDto);
	}
	
	@DeleteMapping("/school/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_TEACHER')")
	public String deleteSchool(@PathVariable Long id) {
		return schoolService.deleteSchool(id);
	}
	
}
