/**
 * 
 */
package it.nmadlk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import it.nmadlk.models.Vehicle;
import it.nmadlk.services.VehicleService;

/**
 * @author Navo
 *
 */
@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@ApiOperation(value = "Retrieve all vehicles")
	@RequestMapping(method=RequestMethod.GET, value="/vehicles", produces="application/json")
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	@ApiOperation(value = "Retrieve a vehicle")
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{id}", produces="application/json")
	public Optional<Vehicle> getVehicle(@PathVariable String id) {
		return vehicleService.getVehicle(id);
	}
	
	@ApiOperation(value = "Add a new vehicle")
	@RequestMapping(method=RequestMethod.POST, value="/vehicles", produces="application/json")
	public void addPart(@RequestBody Vehicle vehicle) {
		vehicleService.addVehicle(vehicle);
	}
	
	@ApiOperation(value = "Update a vehicle")
	@RequestMapping(method=RequestMethod.PUT, value="/vehicles/{id}", produces="application/json")
	public void updatePart(@PathVariable String id, @RequestBody Vehicle vehicle) {
		vehicleService.updateVehicle(id, vehicle);
	}
	
	@ApiOperation(value = "Remove a vehicle")
	@RequestMapping(method=RequestMethod.DELETE, value="/vehicles/{id}", produces="application/json")
	public void deleteVehicle(@PathVariable String id) {
		vehicleService.deleteVehicle(id);
	}
	
}
