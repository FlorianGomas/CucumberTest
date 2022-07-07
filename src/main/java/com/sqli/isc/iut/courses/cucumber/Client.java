package com.sqli.isc.iut.courses.cucumber;

public class Client {
	
	private boolean isSick = false;
	private int drinksNumber;

	public int getDrinksNumber() {
		return drinksNumber;
	}

	public void setDrinksNumber(int drinksNumber) {
		this.drinksNumber = drinksNumber;
	}

	public boolean isSick() {
		return isSick;
	}

	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}

	public Client(boolean isSick) {
		this.isSick = isSick;
		this.drinksNumber = 0;
	}

	public Client() {
		this.drinksNumber = 0;
	}
	
	public void drink() {
		drinksNumber +=1;
	}
	
	public boolean isHappy() {
		if(isSick && drinksNumber >=2) {
			return false;
		}
		return true;
	}

	public void pay(Bill bill, int totalPrice) {
		int actualPriceToPay = bill.getBillsPrice();
		bill.setBillsPrice(actualPriceToPay - totalPrice);	
	}

	public void pay(Bill bill,Cocktail cocktail, int i) {
		int actualPriceToPay = bill.getBillsPrice();
		bill.setBillsPrice(actualPriceToPay - (cocktail.getPrice() * i));			
	}

}
