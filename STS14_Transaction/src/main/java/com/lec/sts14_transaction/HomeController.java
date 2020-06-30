package com.lec.sts14_transaction;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//	private TicketDAO1 dao;		// 트랜젝션이 적용되지 않은 dao 친구
	private TicketDAO2 dao;		// 트랜젝션이 적용된 친구
//	private TicketDAO3 dao;
	
	@Autowired   //servelt context에 있는 bean을 주입 받는다~~~
	public void setDao(TicketDAO2 dao) {
		this.dao = dao;
	}
	
	@GetMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";	// 티켓 구매 양식 페이지로 이동
	}
	
	//티켓 구매 처리 (트랜젝션이 일어나는 곳)
	@GetMapping("/buy_ticket_card")
	public String buy_ticket_card(TicketDTO dto, Model model) {
		System.out.println("\tbuy_ticket_card");
		System.out.println("userID : " +dto.getUserId());
		System.out.println("ticket count : "+dto.getTicketCount());
		
		String page = "buy_ticket_done";  //티켓 구매 성공할 경우 이동할 페이지
		
		//트랜젝션이 발생되는 부분
		try {
			dao.buyTicket(dto);
			model.addAttribute("ticketInfo", dto);
			
		}catch (Exception e) {
			e.printStackTrace();
			page="buy_ticket_fail";  //실패할 경우 이동할 페이지
		}
		
		
		
		return page;
		
	}
	
	
	
	
}
