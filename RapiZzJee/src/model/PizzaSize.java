package model;


public class PizzaSize {
	
	private String namePizzaSize;
	private float coefficient;

	
	public PizzaSize (String namePizzaSize, float coefficient) {
		this.setNamePizzaSize(namePizzaSize);
		this.setCoefficient(coefficient);	
	}


	public String getNamePizzaSize() {
		return namePizzaSize;
	}


	public void setNamePizzaSize(String namePizzaSize) {
		this.namePizzaSize = namePizzaSize;
	}

	public float getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

}
