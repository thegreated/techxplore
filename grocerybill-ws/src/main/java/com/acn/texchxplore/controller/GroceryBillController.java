package com.acn.texchxplore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.texchxplore.domain.GroceryBill;
import com.acn.texchxplore.entity.ShoppingClerk;
import com.acn.texchxplore.impl.DiscountedBill;
import com.acn.texchxplore.impl.RegularBill;
import com.acn.texchxplore.repository.ItemRepository;

@CrossOrigin
@RestController
public class GroceryBillController {

	public GroceryBillController() {
		shoppingClerk = new ShoppingClerk("TechXplore");
	}

	@Autowired
	private ItemRepository itemRepo;

	private ShoppingClerk shoppingClerk;

	@GetMapping("/items/bill/regular")
	public GroceryBill getTotalRegularBill() {

		GroceryBill grocery = new RegularBill(shoppingClerk);
		grocery.setItemList(itemRepo.findAll());

		return grocery;
	}

	@GetMapping("/items/bill/discounted")
	public GroceryBill getTotalDiscountedBill() {

		GroceryBill grocery = new DiscountedBill(shoppingClerk);
		grocery.setItemList(itemRepo.findAll());

		return grocery;

	}
}
