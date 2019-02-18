package it.nmadlk.searchRepositories;

import it.nmadlk.models.Vehicle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Navo
 *
 */
public interface VehicleESRepository extends ElasticsearchRepository<Vehicle, String> {

    List<Vehicle> findByMake(String make);
}
