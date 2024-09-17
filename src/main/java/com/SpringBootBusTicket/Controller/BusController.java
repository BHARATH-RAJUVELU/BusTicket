package com.SpringBootBusTicket.Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringBootBusTicket.Entity.BusTicket;
import com.SpringBootBusTicket.Entity.Tickets;
import com.SpringBootBusTicket.Service.BusService;



@Controller
@RequestMapping("/")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome";
	}
	
	@GetMapping("/busregistration")
	public String showRegistrationForm(Model model) {
		BusTicket user=new BusTicket();
	    model.addAttribute("user",user);  
	    return "Registration";
	}

	@PostMapping("/busregistration") 
	public String create(@ModelAttribute BusTicket ticket,Model model) {
		model.addAttribute("successMessage", "Registration successful! please login.");
	ticket.setPassword(encoder.encode(ticket.getPassword()));
	 busService.Register(ticket);
	    return "redirect:/login?Success";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
	    return "login";
	}

	@GetMapping("/submitForm")
	public String SubmitForm() {
		return "Home";
	}
	
	@GetMapping("/search-buses")
    public String showSearchPages(Model model) {
		model.addAttribute("tickets",new Tickets());
        List<String> fromPlaces = Arrays.asList("Bangalore", "Mysore", "Mangalore", "Hubli", "Chikkamagaluru");
        model.addAttribute("fromPlaces", fromPlaces);
        List<String> toPlaces = Arrays.asList("Bangalore", "Mysore", "Mangalore", "Hubli", "Chikkamagaluru");
        model.addAttribute("toPlaces", toPlaces);
        return "Search";
	}
	
	@PostMapping("/search-buses")
	public String Save(@ModelAttribute Tickets tickets) {
		busService.saveTickets(tickets);
//		busService.createBusTicket(BusTicketId, tickets);
		return "Search";
		
	}
	


}
