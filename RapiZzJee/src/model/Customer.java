package model;

import java.sql.Date;

public class Customer extends Person {
	
	private float balance;

	public Customer(int idPerson, String namePerson, String surnamePerson, Date birthDate, String mail, String phone,
			String address, String ville, int postalCode, float balance) {
		super(idPerson, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode);
		this.balance = balance;
	}
	
	
	public boolean checkBalance (float price) {
		if (balance >= price) {
			return true;
		}
		else {
			return false;
		}
	}
		
}
