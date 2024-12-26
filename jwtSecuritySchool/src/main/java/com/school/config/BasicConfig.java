//package com.school.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class BasicConfig {
//
//	@Bean 
//	public UserDetailsService userDetailService() {
//		
//		 UserDetails teacher=User.withUsername("Nikhil")
//		 .password(passwordEncoder().encode("Pwd1"))
//		 .roles("ADMIN").build();
//		 
//		 UserDetails student=User.withUsername("Banu")
//				 .password(passwordEncoder().encode("Pwd2"))
//				 .roles("STUDENT").build();
//		 
//		 UserDetails admin=User.withUsername("Seenu")
//				 .password(passwordEncoder().encode("Pwd3"))
//				 .roles("ADMIN").build();
//		 
//		 return new InMemoryUserDetailsManager(teacher,student,admin);
//		 	}
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf().disable().authorizeRequests()
//				.requestMatchers("/school","/schools").permitAll()
//				.and()
//				.authorizeRequests()
//				.requestMatchers("/school/**").authenticated()
//				.and()
//				.httpBasic()
//				.and()
//				.build();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
