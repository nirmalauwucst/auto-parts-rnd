package it.nmadlk.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;

@Configuration
@EnableJpaRepositories(basePackages = "it.nmadlk.repositories")
@EnableElasticsearchRepositories(basePackages = "it.nmadlk.searchRepositories")
public class DbRepositoryConfiguration {

    @Value("${elasticsearch.host}")
    private String elasticsearchHost;

    @Value("${elasticsearch.port}")
    private int elasticsearchPort;

    @Value("${elasticsearch.cluster.name}")
    private String elasticsearchClusterName;

    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.builder()
                .put("cluster.name", elasticsearchClusterName)
                .build();

        //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
        return new PreBuiltTransportClient(esSettings)
                .addTransportAddress(
                        new TransportAddress(InetAddress.getByName(elasticsearchHost), elasticsearchPort));
    }

   /* @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }*/
}
