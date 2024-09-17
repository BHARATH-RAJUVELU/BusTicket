package com.SpringBootBusTicket.Entity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;


public class BusTicketPrincipal implements UserDetails {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BusTicket busTicket;

	public BusTicketPrincipal(BusTicket busTicket2) {
		this.busTicket=busTicket2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return busTicket.getPassword();
	}
    
	@Override
	public String getUsername() {
		return busTicket.getUsername();
	}

}
