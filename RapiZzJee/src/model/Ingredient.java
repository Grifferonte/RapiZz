package model;


public class Ingredient {
	
	private int idIngredient;
	private String nameIngredient;

	
	public Ingredient (int idIngredient, String nameIngredient) {
		this.setIdIngredient(idIngredient);
		this.setNameIngredient(nameIngredient);
		
	}


	public int getIdIngredient() {
		return idIngredient;
	}


	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}


	public String getNameIngredient() {
		return nameIngredient;
	}


	public void setNameIngredient(String nameIngredient) {
		this.nameIngredient = nameIngredient;
	}

}
