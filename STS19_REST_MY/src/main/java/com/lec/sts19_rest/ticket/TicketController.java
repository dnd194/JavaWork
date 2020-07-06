package com.lec.sts19_rest.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.javafx.collections.MappingChange.Map;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@GetMapping("/buy_ticket")
	public String buyTicket() {
		return "ticket/buy_ticket";
	}
	
	
	//티켓 구매 처리 (트랜젝션)
	@GetMapping("/buy_ticket_card")
	public String buyTicketCard(TicketDTO dto, Model model) {
		
		String page = "ticket/buy_ticket_done";
		
		
		try {
			ticketService.buyTicket(dto);
			model.addAttribute("ticketInfo", dto);
		} catch (Exception e) {
			e.printStackTrace();
			page = "ticket/buy_ticket_fail";
			
		}
		
		
		
		return page;
	}
	
	
	
	
	
}
