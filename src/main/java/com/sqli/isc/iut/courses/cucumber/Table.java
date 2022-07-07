package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private List <Client> clientList = new ArrayList<Client>();
	private Bill bill;

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public void addClient(Client client) {
		clientList.add(client);
	}

	public int countClients() {
		return clientList.size();
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}


}
