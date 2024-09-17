package com.SpringBootBusTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootBusTicket.Entity.Tickets;

public interface TicketRepo  extends JpaRepository<Tickets, Integer>{

}
