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
@Document(indexName = "vehicle-ap", type = "vehicles")
public class Vehicle implements Serializable {

	@Id
	private String id;
	private String make;
	private String model;
	private String trimLevel;
	private String modelYear;
	private String targetMarket;
	
	
	public Vehicle() {
		
	}

	public Vehicle(String id, String make, String model, String trimLevel, String modelYear, String targetMarket) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.trimLevel = trimLevel;
		this.modelYear = modelYear;
		this.targetMarket = targetMarket;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTrimLevel() {
		return trimLevel;
	}
	public void setTrimLevel(String trimLevel) {
		this.trimLevel = trimLevel;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String year) {
		this.modelYear = year;
	}
	public String getTargetMarket() {
		return targetMarket;
	}
	public void setTargetMarket(String targetMarket) {
		this.targetMarket = targetMarket;
	}
	
	

}
