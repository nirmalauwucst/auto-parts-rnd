package it.nmadlk.services;


import it.nmadlk.models.Vehicle;
import it.nmadlk.searchRepositories.PartESRepository;
import it.nmadlk.searchRepositories.VehicleESRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {


    @Autowired
    private PartESRepository partESRepository;

    @Autowired
    private VehicleESRepository vehicleESRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public List<Vehicle> searchByVehicleMake(String make){
        return vehicleESRepository.findByMake(make);
    }

    public List<Vehicle> searchByVehicleModel(String model){
        return vehicleESRepository.findByModel(model);
    }

    public List<Vehicle> searchAll(){
        List<Vehicle> vehiclesList = new ArrayList<>();
        Iterable<Vehicle> vehicles = vehicleESRepository.findAll();
        vehicles.forEach(vehiclesList::add);
        return vehiclesList;
    }

    public List<Vehicle> searchAllMultiParams(String text){
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)
                                .field("make")
                                .field("model")
                                .field("modelYear")
                                .field("targetMarket")
                ).should(
                        QueryBuilders.queryStringQuery("*" + text + "*")
                                .lenient(true)
                                .field("make")
                                .field("model")
                                .field("modelYear")
                                .field("targetMarket")
                );

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        List<Vehicle> vehicles = elasticsearchTemplate.queryForList(build, Vehicle.class);
        return vehicles;
    }



}
