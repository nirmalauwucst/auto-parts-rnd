/**
 * 
 */
package it.nmadlk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nmadlk.models.Vehicle;

/**
 * @author Navo
 *
 */
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
