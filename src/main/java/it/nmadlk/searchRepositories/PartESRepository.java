package it.nmadlk.searchRepositories;

import it.nmadlk.models.Part;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author Navo
 *
 */
public interface PartESRepository extends ElasticsearchRepository<Part, String> {
}
