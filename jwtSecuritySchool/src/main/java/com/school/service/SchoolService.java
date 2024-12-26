package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.dto.RequestDto;
import com.school.entity.School;
import com.school.repository.SchoolRepository;

@Service
public class SchoolService {

	public final static String DEFAULT_ROLE="ROLE_STUDENT";
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public School createSchool(RequestDto requestDto) {
		School school=new School();
		school.setName(requestDto.getName());
		school.setMobile(requestDto.getMobile());
		school.setMail(requestDto.getMail());
		school.setSection(requestDto.getSection());
		school.setUsername(requestDto.getUsername());
		school.setPassword(passwordEncoder.encode(requestDto.getPassword()));
		school.setRoles(DEFAULT_ROLE);
		return schoolRepository.save(school);
	}
	
	public List<School> createMembers(List<RequestDto> requestDtos){
		List<School> schools=new ArrayList<>();
		for(RequestDto requestDto:requestDtos) {
			School school=new School();
			school.setName(requestDto.getName());
			school.setMobile(requestDto.getMobile());
			school.setMail(requestDto.getMail());
			school.setSection(requestDto.getSection());
			school.setUsername(requestDto.getUsername());
			school.setPassword(passwordEncoder.encode(requestDto.getPassword()));
			school.setRoles(DEFAULT_ROLE);
			schools.add(school);
		}
		return schoolRepository.saveAll(schools);
	}

	public School findUsingId(Long id) {
		
		return schoolRepository.findById(id).get();
	}

	public List<School> getUsingAll() {
		return schoolRepository.findAll();
	}
	
	public School updateSchool(Long id,RequestDto requestDto) {
		School school=schoolRepository.findById(id).get();
		school.setName(requestDto.getName());
		schoolRepository.save(school);
		return school;
	}
	
	public String deleteSchool(Long id) {
		schoolRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	
}
