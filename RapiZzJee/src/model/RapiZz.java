package model;

import java.util.ArrayList;

public class RapiZz {
    private ArrayList<Pizza> Pizzas;
    private ArrayList<Customer> Customers;
    private ArrayList<Deliverer> Deliverers;
    private ArrayList<PizzaSize> PizzaSizes;
    private ArrayList<Vehicle> Vehicles;
    private ArrayList<Ingredient> Ingredients;
    private ArrayList<OrderPizza> OrderPizzas;
    
    public RapiZz () {
		this.setPizzas(new ArrayList<Pizza>());
		this.setCustomers(new ArrayList<Customer>());
		this.setDeliverers(new ArrayList<Deliverer>());
		this.setPizzaSizes(new ArrayList<PizzaSize>());
		this.setVehicles(new ArrayList<Vehicle>());
		this.setIngredients(new ArrayList<Ingredient>());
		this.setOrderPizzas(new ArrayList<OrderPizza>()); 
    }

	public ArrayList<Pizza> getPizzas() {
		return Pizzas;
	}

	public void setPizzas(ArrayList<Pizza> pizzas) {
		Pizzas = pizzas;
	}

	public ArrayList<Customer> getCustomers() {
		return Customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		Customers = customers;
	}

	public ArrayList<Deliverer> getDeliverers() {
		return Deliverers;
	}

	public void setDeliverers(ArrayList<Deliverer> deliverers) {
		Deliverers = deliverers;
	}

	public ArrayList<PizzaSize> getPizzaSizes() {
		return PizzaSizes;
	}

	public void setPizzaSizes(ArrayList<PizzaSize> pizzaSizes) {
		PizzaSizes = pizzaSizes;
	}

	public ArrayList<Vehicle> getVehicles() {
		return Vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		Vehicles = vehicles;
	}

	public ArrayList<Ingredient> getIngredients() {
		return Ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		Ingredients = ingredients;
	}

	public ArrayList<OrderPizza> getOrderPizzas() {
		return OrderPizzas;
	}

	public void setOrderPizzas(ArrayList<OrderPizza> orderPizzas) {
		OrderPizzas = orderPizzas;
	}
    
    


}
