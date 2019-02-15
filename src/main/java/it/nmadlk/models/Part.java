/**
 * 
 */
package it.nmadlk.models;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Navo
 *
 */

@Entity
@Document(indexName = "part-ap", type = "parts")
public class Part implements Serializable {

	@Id
	private String id;
	private String partName;
	private String partCategory;
	private double unitCost;
	private String description;
	
	 //(Inspiration!) Many parts for One vehicle
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
