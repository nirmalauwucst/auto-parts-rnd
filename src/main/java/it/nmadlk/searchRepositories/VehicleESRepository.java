package it.nmadlk.searchRepositories;

import it.nmadlk.models.Vehicle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Navo
 *
 */
public interface VehicleESRepository extends ElasticsearchRepository<Vehicle, String> {
}
