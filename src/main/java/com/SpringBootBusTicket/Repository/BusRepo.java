package com.SpringBootBusTicket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootBusTicket.Entity.BusTicket;
import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepo  extends JpaRepository<BusTicket, Integer>{

	BusTicket findByUsername(String username);

}
