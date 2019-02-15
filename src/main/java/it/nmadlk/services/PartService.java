/**
 * 
 */
package it.nmadlk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nmadlk.models.Part;
import it.nmadlk.repositories.PartRepository;

/**
 * @author Navo
 * Business Service for parts 
 * 
 * (Note!)If you are using the "Derby" as database, the framework sees the embedded Derby database in the classpath 
 * and assumes that to be the database to connect to. No connection information necessary.
 */

@Service
public class PartService {
	
	@Autowired
	private PartRepository partRepository;
	
	/**
	 * findAll() is an Iterable<Part> in CrudRepository
	 * @param id 
	 * @return parts
	 */
	public List<Part> getAllParts(String vehicleId){
		List<Part> parts = new ArrayList<>();
		partRepository.findByVehicleId(vehicleId).forEach(parts::add);
		return parts;
	}
	
	public Optional<Part> getPart(String id) {
		return partRepository.findById(id);
	}

	/**
	 * Using the save method in CrudRepository
	 * @param part
	 */
	public void addPart(Part part) {
		partRepository.save(part); 
	}
 
	/**
	 * This will do the update if the record does not exist.
	 * @param id
	 * @param part
	 */
	public void updatePart(String id,Part part) {
		partRepository.save(part); 
	}

	public void deletePart(String id) {
		partRepository.deleteById(id);
	}
}
