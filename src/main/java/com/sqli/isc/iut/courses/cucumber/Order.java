package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Cocktail> cocktailList = new ArrayList<Cocktail>();
	private int totalPrice = 0;
	
	public List<Cocktail> getCocktailList() {
		return cocktailList;
	}

	public void setCocktailList(List<Cocktail> cocktailList) {
		this.cocktailList = cocktailList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void addCocktail(Cocktail cocktail, int numbers) {
		for(int i = 0; i < numbers; i++) {
			cocktailList.add(cocktail);
			totalPrice += cocktail.getPrice();
		}		
	}

	public Integer countCocktails() {
		return cocktailList.size();
	}

}
