package model;

import java.sql.Date;

public class Person {
    private int idPerson;
    private String namePerson;
    private String surnamePerson;
    private Date birthDate;
    private String mail;
    private String phone;
    private String address;
    private String ville;
    private int postalCode;
    
    public Person(int idPerson, String namePerson, String surnamePerson, Date birthDate, String mail, String phone, String address, String ville, int postalCode) {
    	this.setIdPerson(idPerson);
    	this.setNamePerson(namePerson);
    	this.setSurnamePerson(surnamePerson);
    	this.setBirthDate(birthDate);
    	this.setMail(mail);
    	this.setPhone(phone);
    	this.setAddress(address);
    	this.setVille(ville);
    	this.setPostalCode(postalCode);
    }

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getSurnamePerson() {
		return surnamePerson;
	}

	public void setSurnamePerson(String surnamePerson) {
		this.surnamePerson = surnamePerson;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
}
