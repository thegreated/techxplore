package com.acn.texchxplore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.acn.texchxplore.model.GroceryBill;

@Controller
public class GroceryBillController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/grocery")
	public String getIndexPage(Model model) {

		GroceryBill regularBill = restTemplate.getForObject("hsttp://webservice/items/bill/regular", GroceryBill.class);
		model.addAttribute("clerk", regularBill.getClerk());
		model.addAttribute("regularBill", regularBill);

		GroceryBill discountedBill = restTemplate.getForObject("http://webservice/items/bill/discounted",
				GroceryBill.class);
		model.addAttribute("discountedBill", discountedBill);

		return "grocery";
	}

}
