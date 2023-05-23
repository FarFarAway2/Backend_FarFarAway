package com.farfaraway.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.farfaraway.app.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class FarFarAwaySecurityConfig {

	// ADMIN URLs
	private static final String[] SECURED_URLs = { "/hoteloffers/**" };

	// USER URLs
	private static final String[] USER_SECURED_URLs = { "/traveloffers/**" };

	// COMPANY URLs
	private static final String[] COMPANY_SECURED_URLs = { "/userroles/**" };

	// OPEN URLs
	private static final String[] UN_SECURED_URLs = { "/users/**", "/login/**" };

	@Autowired
	private JWTAuthenticationFilter authenticationFilter;

	@Autowired
	private FarFarAwayUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		var authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests().requestMatchers(UN_SECURED_URLs).permitAll().and()
				.authorizeHttpRequests().requestMatchers(SECURED_URLs).hasAuthority("ADMIN").and()
				.authorizeHttpRequests().requestMatchers(USER_SECURED_URLs).hasAuthority("USER").and()
				.authorizeHttpRequests().requestMatchers(COMPANY_SECURED_URLs).hasAuthority("COMPANY").anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}