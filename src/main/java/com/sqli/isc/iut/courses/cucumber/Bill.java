package com.sqli.isc.iut.courses.cucumber;

import java.util.LinkedList;
import java.util.Queue;

public class Bill {
	
	private Queue <Order> orderList = new LinkedList<Order>();
	int billsPrice;

	public Queue<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Queue<Order> orderList) {
		this.orderList = orderList;
	}

	public int getBillsPrice() {
		return billsPrice;
	}

	public void setBillsPrice(int billsPrice) {
		this.billsPrice = billsPrice;
	}

	public Integer getTotalPrice() {
		int totalPrice = 0;
		for(Order order : orderList) {
			totalPrice += order.getTotalPrice();
		}
		return totalPrice;
	}

	public void addOrder(Order order) {
		orderList.add(order);
		billsPrice = order.getTotalPrice();
	}

	public void updateBill() {
		orderList.poll();	
	}}
