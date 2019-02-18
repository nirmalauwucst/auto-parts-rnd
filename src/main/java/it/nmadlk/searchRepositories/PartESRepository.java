package it.nmadlk.searchRepositories;

import it.nmadlk.models.Part;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @author Navo
 *
 */
public interface PartESRepository extends ElasticsearchRepository<Part, String> {

    List<Part> findByVehicle_Make(String vehicleMake);
}
