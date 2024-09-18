package com.SpringBootBusTicket.Service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootBusTicket.Entity.BusTicket;
import com.SpringBootBusTicket.Entity.Tickets;
import com.SpringBootBusTicket.Repository.BusRepo;
import com.SpringBootBusTicket.Repository.TicketRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusService {
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private TicketRepo repo;

//	public Tickets createBusTicket(Integer BusTicketId, Tickets tickets) {
//	    // Fetch the Registration (user) by ID
//	    Optional<BusTicket> busTicket = busRepo.findById(BusTicketId);
//
//	    if (busTicket == null) {
//	        throw new IllegalArgumentException("Invalid registration ID");
//	    }
//
//	    // Associate the BusTicket with the fetched Registration
//	    tickets.setBusTicket(busTicket);
//
//	    return repo.save(tickets);
//	}

	
	public BusTicket Register(BusTicket busTicket) {
		return busRepo.save(busTicket);
	}

	public Tickets saveTickets(Tickets tickets) {
		return repo.save(tickets);
	}
	public BusTicket getuser(String email) {
		return busRepo.findByUsername(email);
	}
	
}
