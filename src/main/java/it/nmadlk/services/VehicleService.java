/**
 * 
 */
package it.nmadlk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nmadlk.models.Vehicle;
import it.nmadlk.repositories.VehicleRepository;

/**
 * @author Navo
 *
 */
@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> getAllVehicles(){
		List<Vehicle> vehicles = new ArrayList<>();
		vehicleRepository.findAll().forEach(vehicles::add);
		return vehicles;
	}
	
	public Optional<Vehicle> getVehicle(String id){
		return vehicleRepository.findById(id);
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	public void updateVehicle(String id, Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	public void deleteVehicle(String id) {
		vehicleRepository.deleteById(id);
	}
	
}
