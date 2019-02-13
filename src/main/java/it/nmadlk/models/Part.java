/**
 * 
 */
package it.nmadlk.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Navo
 *
 */

@Entity
public class Part {
	
	@Id
	private String id;
	private String partName;
	private String partCategory;
	private double unitCost;
	private String description;
	
	 //(Inspiration!) Many parts for One vehicle
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Vehicle vehicle;
	
	
	public Part() {
		
	}


	public Part(String id, String partName, String partCategory, double unitCost, String description, String vehicleId) {
		super();
		this.id = id;
		this.partName = partName;
		this.partCategory = partCategory;
		this.unitCost = unitCost;
		this.description = description;
		this.vehicle = new Vehicle(vehicleId,"","","","","");
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getPartCategory() {
		return partCategory;
	}


	public void setPartCategory(String partCategory) {
		this.partCategory = partCategory;
	}


	public double getUnitCost() {
		return unitCost;
	}


	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
	
}
