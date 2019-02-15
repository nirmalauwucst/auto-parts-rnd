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
import it.nmadlk.models.Part;
import it.nmadlk.models.Vehicle;
import it.nmadlk.services.PartService;

/**
 * @author Navo
 *
 */
@RestController
@RequestMapping("/vehicles")
public class PartController {
	//@Autowired, which marks that,need of dependency injection for member variable from a service
	@Autowired
	private PartService partService;
	
	@ApiOperation(value = "Retrieve all spare parts of a vehicle")
	@RequestMapping(method=RequestMethod.GET, value="/{id}/parts", produces="application/json" )
	public List<Part> getAllParts(@PathVariable String id) {
		return partService.getAllParts(id);
	}
	
	@ApiOperation(value = "Retrieve a spare part of a vehicle")
	@RequestMapping(method=RequestMethod.GET, value="/{vehicleId}/parts/{id}", produces="application/json")
	public Optional<Part> getPart(@PathVariable String vehicleId, @PathVariable String id) {
		return partService.getPart(id);
	}
	
	@ApiOperation(value = "Add a new spare part")
	@RequestMapping(method=RequestMethod.POST, value="/{vehicleId}/parts", produces="application/json")
	public void addPart(@RequestBody Part part, @PathVariable String vehicleId) {
		part.setVehicle(new Vehicle(vehicleId,"","","","",""));
		partService.addPart(part);
	}
	
	@ApiOperation(value = "Update a spare part")
	@RequestMapping(method=RequestMethod.PUT, value="/{vehicleId}/parts/{id}", produces="application/json")
	public void updatePart(@RequestBody Part part, @PathVariable String vehicleId, @PathVariable String id) {
		part.setVehicle(new Vehicle(vehicleId, "","","","",""));
		partService.updatePart(id, part);
	}
	
	@ApiOperation(value = "Remove a spare part")
	@RequestMapping(method=RequestMethod.DELETE, value="/{vehicleId}/parts/{id}", produces="application/json")
	public void deletePart(@PathVariable String id) {
		partService.deletePart(id);
	}
	
	
	
}
