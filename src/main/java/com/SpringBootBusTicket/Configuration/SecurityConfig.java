package com.SpringBootBusTicket.Configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.SpringBootBusTicket.Entity.BusTicket;
import com.SpringBootBusTicket.Service.BusService;
import com.SpringBootBusTicket.Service.CustomerDetailsService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@Autowired
	private BusService busService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(customerDetailsService);
		provider.setPasswordEncoder(encoder());
		return provider;
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(authz -> {
			authz.requestMatchers("/busregistration","/login","/submitForm","/","/search-buses").permitAll();
			authz.anyRequest().authenticated();
		})
		.formLogin(formlogin-> {
			formlogin.loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
		
				@Override
				@Bean
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					String username = authentication.getName();
			        System.out.println(username );
			        // Retrieve the user object from the database
			        BusTicket user = busService.getuser(username);
			        if(user==null) {
			        	System.out.println("user is null");
			        }
			        
			        // Store the user object in the session
			        HttpSession session = request.getSession();
			        session.setAttribute("bus", user);
					response.sendRedirect("/search-buses");
					
				}
				
				
			});
		})
		.build();
	}
	
}
