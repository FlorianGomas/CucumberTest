package com.sqli.isc.iut.courses.cucumber;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarSteps {
	private Bar leJuste = new Bar(10);
	private Cocktail monthCocktail = new Cocktail(10);
	private Bill bill = new Bill();
	private Client pignon = new Client(true);
	private Client leblanc = new Client(false);
	private Table table = new Table();

	@Given("they are {int} people in the bar")
	public void they_are_some_people_in_the_bar(int numberOfPeople) throws Throwable {
		leJuste.clientTakeASeat(numberOfPeople);
		assertEquals(numberOfPeople, leJuste.countClients()); 
	}
	
	@When("^Mr.Pignon and Mr.Leblanc arrive and try to get into the bar$")
	public void pignon_and_leblanc_try_to_get_into_the_bar() throws Throwable {
		if(leJuste.getAvailableSeats() >= 2) {
			table.addClient(pignon);
			table.addClient(leblanc);
			table.setBill(bill);
			leJuste.clientTakeASeat(2);
			assertEquals(2, table.countClients());	
		}else {
			Exception exception = assertThrows(IllegalArgumentException.class, () -> {
				leJuste.clientTakeASeat(2);
			});
		}
	}
	
	@When("^they both order a months cocktail$")
	public void they_both_order_month_cocktail() throws Throwable {
		Order firstOrder = new Order();
		firstOrder.addCocktail(monthCocktail, 2);
		bill.addOrder(firstOrder);
		assertEquals(2, firstOrder.countCocktails());
	}
	
	@When("^after the drinks are empty they check the bill$")
	public void check_the_bill() throws Throwable {
		pignon.drink();
		leblanc.drink();
		int orderPrice = 0;
		for(Order order : bill.getOrderList()) {
			orderPrice += order.getTotalPrice(); 
		}
		assertEquals(orderPrice,bill.getTotalPrice());
	}
	
	@When("^Mr.Leblanc pays for each$")
	public void leblanc_pay_the_bill() throws Throwable {
		leblanc.pay(bill, bill.getTotalPrice() );
		bill.updateBill();
		assertEquals(0, bill.getBillsPrice());
	}
	
	@When("Mr.Leblanc insist to order {int} more months cokctail on his bill")
	public void leblanc_order_2_more_drinks(int numberOfDrinks) throws Throwable {
		Order secondOrder = new Order();
		secondOrder.addCocktail(monthCocktail, numberOfDrinks);
		bill.addOrder(secondOrder);
		assertEquals(2, secondOrder.countCocktails());
	}
	
	@When("^each one pays his own drinks$")
	public void each_one_pays_his_own() throws Throwable {
		leblanc.pay(bill,monthCocktail, 1);
		pignon.pay(bill,monthCocktail, 1);
		bill.updateBill();
		assertEquals(0, bill.getBillsPrice());
	}
	
	@Then("^they cannot enter$")
	public void they_cannot_enter() throws Throwable {
		List<Client> clients = new ArrayList<Client>();
		clients.add(leblanc);
		clients.add(pignon);
		assertTrue(leJuste.isFull(clients));
	}
	
	@Then("^the bar is full no more customer can enter$")
	public void the_bar_is_full_no_more_customer_can_enter() throws Throwable {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			leJuste.clientTakeASeat(1);
		});
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client());
		assertTrue(leJuste.isFull(clients));
	}
	
	@Then("^Mr.Pignon is happy$")
	public void mr_pignon_is_happy() throws Throwable {
		assertEquals(true, pignon.isHappy());
	}
	
	@Then("^Mr.Pignon is sad$")
	public void mr_pignon_is_sad() throws Throwable {
		assertEquals(false, pignon.isHappy());
	}
}
