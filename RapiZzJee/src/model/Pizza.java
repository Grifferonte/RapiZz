package model;

import java.sql.Connection;

public class Pizza {
    private int idPizza;
    private String namePizza;
    private float basePrice;
    private static Connection connexionDB;


	public Pizza(int idPizza, String namePizza, float basePrice) {
		this.setIdPizza(idPizza);
		this.setNamePizza(namePizza);
		this.setBasePrice(basePrice);
	}


	public int getIdPizza() {
		return idPizza;
	}


	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}


	public String getNamePizza() {
		return namePizza;
	}


	public void setNamePizza(String namePizza) {
		this.namePizza = namePizza;
	}


	public float getBasePrice() {
		return basePrice;
	}


	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}


	public static Connection getConnexionDB() {
		return connexionDB;
	}


	public static void setConnexionDB(Connection connexionDB) {
		Pizza.connexionDB = connexionDB;
	}
	
	

}
