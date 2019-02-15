package it.nmadlk.serachRepositories;

import it.nmadlk.models.Part;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PartESRepository extends ElasticsearchRepository<Part, String> {
}
