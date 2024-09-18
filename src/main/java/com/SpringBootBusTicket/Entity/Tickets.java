package com.SpringBootBusTicket.Entity;

import java.util.Date;
import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Fromplace;
	private String Toplace;
	@Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private int seats;
	
	@ManyToOne
	private BusTicket busTicket;

	public void setBusTicket(BusTicket busTicket2) {
		
		this.busTicket=busTicket2;
		
	}

}
