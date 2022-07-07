package com.sqli.isc.iut.courses.cucumber;

import java.util.List;

public class Bar {
	
	private int availableSeats;
	private int totalSeats;
	
	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}

	public Bar(int numberOfSeats) {
		this.totalSeats = numberOfSeats;
		this.availableSeats = numberOfSeats;
	}

	public void clientTakeASeat(int number) {
		if(availableSeats < number) {
			throw new IllegalArgumentException("Le nombre de client souhaitant entrer dépasse le nombre de places disponible");
		} else {
			availableSeats = availableSeats - number;
		}	
	}

	public Integer countClients() {
		return totalSeats - availableSeats;
	}

	public boolean isFull(List<Client> clients) {
		if(availableSeats == 0 || clients.size() > availableSeats) {
			return true;
		}
		return false;
	}

}
