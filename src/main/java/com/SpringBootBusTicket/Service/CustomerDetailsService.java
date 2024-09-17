package com.SpringBootBusTicket.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringBootBusTicket.Entity.BusTicket;
import com.SpringBootBusTicket.Entity.BusTicketPrincipal;
import com.SpringBootBusTicket.Repository.BusRepo;

@Service
public class CustomerDetailsService implements UserDetailsService {
	
	@Autowired
	
	private BusRepo busRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		BusTicket busTicket=busRepo.findByUsername(username);
		
			BusTicket busTicket2=busTicket;
		
		BusTicketPrincipal busTicketPrincipal= new  BusTicketPrincipal(busTicket2);
		
		return busTicketPrincipal;
	}
	

}
