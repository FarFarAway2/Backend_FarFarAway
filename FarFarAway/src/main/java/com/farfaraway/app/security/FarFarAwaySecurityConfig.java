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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.farfaraway.app.jwt.JWTAuthenticationFilter;

import io.jsonwebtoken.lang.Arrays;

@Configuration
@EnableWebSecurity
public class FarFarAwaySecurityConfig {

	// ADMIN URLs
	private static final String[] SECURED_URLs = {};

	// USER URLs
	private static final String[] USER_SECURED_URLs = {};

	// COMPANY URLs
	private static final String[] COMPANY_SECURED_URLs = {};

	// OPEN URLs
	private static final String[] UN_SECURED_URLs = { "/login/**", "/register/**", "/traveloffers/**", "/hoteloffers/**" , "/users/**"};

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
	
	@Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(java.util.Arrays.asList("https://main.df7xyjdxqxvgb.amplifyapp.com"));
        corsConfig.setAllowedMethods(java.util.Arrays.asList("GET", "POST"));
        corsConfig.setMaxAge(8000L);
        corsConfig.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }

}