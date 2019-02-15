/**
 * 
 */
package it.nmadlk.repository;

import org.springframework.data.repository.CrudRepository;

import it.nmadlk.models.Vehicle;

/**
 * @author Navo
 *
 */
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}
