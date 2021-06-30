package model;

public class Vehicle {
    private String plateNumber;
    private String typeVehicle;

	public Vehicle(String plateNumber, String typeVehicle) {
		this.setPlateNumber(plateNumber);
		this.setTypeVehicle(typeVehicle);
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
}
