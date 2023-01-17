package com.accenture.api.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.accenture.api.model.CarPark_Data;
import com.accenture.api.model.CarPark_Info;
import com.accenture.api.model.OverallAvailableSlots;
//import com.accenture.api.model.Pricing;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class APIController {


	@RequestMapping("/hello")
	public String hello() {
		return "Hello User";
	}
	
	@GetMapping(value="/welcome")
	private String getWelcome() {
		String uri = "http://localhost:8080/hello";
		RestTemplate template = new RestTemplate();
		String result = template.getForObject(uri,String.class);
		return result;
	}
	
	
	@GetMapping(value="/carpark")
	public OverallAvailableSlots getCarpark() throws JsonMappingException, JsonProcessingException  {
		String url = "https://api.data.gov.sg/v1/transport/carpark-availability";
		RestTemplate template = new RestTemplate();
		
		String result = template.getForObject(url,String.class);
	
		ObjectMapper objectMapper = new ObjectMapper();
	    
		OverallAvailableSlots OM = objectMapper.readValue(result, OverallAvailableSlots.class);
		
		
		// Get carpark lots
		CarPark_Info info = new CarPark_Info();
		System.out.println(info.getTotal_lots());
		System.out.println(info.getLots_available());
		
		//Get carpark number
	    CarPark_Data data = new CarPark_Data ();
	    
	    System.out.println(data.getCarpark_number());
		
	    
		
//		// Get Pricing
//	    Pricing p = new Pricing();
//	 if( Integer.parseInt( info.getLots_available())/Integer.parseInt( info.getTotal_lots())== 0 || Integer.parseInt( info.getLots_available())/Integer.parseInt( info.getTotal_lots())== undefined) {
//		System.out.println("Parking Lot is Full");
//		
//	}
//	else if( Integer.parseInt( info.getLots_available())/Integer.parseInt( info.getTotal_lots())==1) {
//			System.out.println("Parking Fee is $" + Integer. toString(p.getBaseprice()));
//			System.out.println(data.getCarpark_number());
//			System.out.println(info.getTotal_lots());
//			System.out.println(info.getLots_available());
//		}
//		else if( Integer.parseInt( info.getLots_available())/Integer.parseInt( info.getTotal_lots())== 0.5) {
//			System.out.println("Parking Fee is $" + Integer. toString(p.getBaseprice() + 3));
//			System.out.println(data.getCarpark_number());
//			System.out.println(info.getTotal_lots());
//			System.out.println(info.getLots_available());
//		}
//		
//		else if( Integer.parseInt( info.getLots_available())/Integer.parseInt( info.getTotal_lots())== 0.3) {
//			System.out.println("Parking Fee is $" +Integer. toString( p.getBaseprice() + 5));
//			System.out.println(data.getCarpark_number());
//			System.out.println(info.getTotal_lots());
//			System.out.println(info.getLots_available());
//		}
//		else if( Integer.parseInt( info.getLots_available())/Integer.parseInt( info.getTotal_lots())== 0.1) {
//			System.out.println("Parking Fee is $" + Integer. toString(p.getBaseprice() + 7));
//			System.out.println(data.getCarpark_number());
//			System.out.println(info.getTotal_lots());
//			System.out.println(info.getLots_available());
//		}
//		
		System.out.println(OM);
		return OM;
	
		
		
		
		
	}
	
}
