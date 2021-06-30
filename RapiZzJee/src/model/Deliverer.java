package model;

import java.sql.Date;

public class Deliverer extends Person {


	public Deliverer(int idPerson, String namePerson, String surnamePerson, Date birthDate, String mail, String phone,
			String address, String ville, int postalCode) {
		super(idPerson, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode);
	}

}
