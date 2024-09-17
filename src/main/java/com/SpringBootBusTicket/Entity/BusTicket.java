package com.SpringBootBusTicket.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Frist_name;
	private String Last_name;
	private long phone_number;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "busTicket",cascade = CascadeType.ALL)
	private List<Tickets> tickets;

}
