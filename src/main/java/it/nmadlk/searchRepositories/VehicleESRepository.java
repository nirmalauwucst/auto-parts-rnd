package it.nmadlk.serachRepositories;

import it.nmadlk.models.Vehicle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface VehicleESRepository extends ElasticsearchRepository<Vehicle, String> {
}
