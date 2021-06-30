package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class OrderPizza {
	private int idOrderPizza;
	private int idPizza;
	private int idDeliverer;
	private int idCustomer;
	private String plateNumber;
	private String namePizzaSize;
	private Time timeDelivery;
	private Date dateOrder;
	private ArrayList<OrderPizza> OrderPizzas = new ArrayList<>();

	public OrderPizza(int idOrderPizza, int idPizza, int idDeliverer, int idCustomer, String plateNumber, String namePizzaSize,  Time timeDelivery, Date dateOrder) {
		this.setIdOrderPizza(idOrderPizza);
		this.setIdPizza(idPizza);
		this.setIdDeliverer(idDeliverer);
		this.setIdCustomer(idCustomer);
		this.setPlateNumber(plateNumber);
		this.setNamePizzaSize(namePizzaSize);
		this.setTimeDelivery(timeDelivery);
		this.setDateOrder(dateOrder);
	}


	public int getIdOrderPizza() {
		return idOrderPizza;
	}


	public void setIdOrderPizza(int idOrderPizza) {
		this.idOrderPizza = idOrderPizza;
	}


	public int getIdPizza() {
		return idPizza;
	}


	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}


	public int getIdDeliverer() {
		return idDeliverer;
	}


	public void setIdDeliverer(int idDeliverer) {
		this.idDeliverer = idDeliverer;
	}


	public int getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}


	public String getPlateNumber() {
		return plateNumber;
	}


	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}


	public String getNamePizzaSize() {
		return namePizzaSize;
	}


	public void setNamePizzaSize(String namePizzaSize) {
		this.namePizzaSize = namePizzaSize;
	}


	public Time getTimeDelivery() {
		return timeDelivery;
	}


	public void setTimeDelivery(Time timeDelivery) {
		this.timeDelivery = timeDelivery;
	}


	public Date getDateOrder() {
		return dateOrder;
	}


	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}


	public ArrayList<OrderPizza> getOrderPizzas() {
		return OrderPizzas;
	}


	public void setOrderPizzas(ArrayList<OrderPizza> orderPizzas) {
		OrderPizzas = orderPizzas;
	}
}