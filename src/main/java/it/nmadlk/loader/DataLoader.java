package it.nmadlk.loader;

import it.nmadlk.models.Part;
import it.nmadlk.models.Vehicle;
import it.nmadlk.repositories.PartRepository;
import it.nmadlk.repositories.VehicleRepository;
import it.nmadlk.searchRepositories.PartESRepository;
import it.nmadlk.searchRepositories.VehicleESRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleESRepository vehicleESRepository;

    @Autowired
    PartRepository partRepository;

    @Autowired
    PartESRepository partESRepository;


    @PostConstruct
    @Transactional
    public void loadJpaToElastic(){

        operations.putMapping(Vehicle.class);
        operations.putMapping(Part.class);
        System.out.println("Loading Data");

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        vehicleESRepository.saveAll(vehicleList);
        List<Part> partList = partRepository.findAll();
        //partESRepository.saveAll(partList);
        System.out.println("Loading Completed");
    }
}
