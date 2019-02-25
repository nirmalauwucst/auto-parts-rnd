package it.nmadlk.controllers.search;


import io.swagger.annotations.ApiOperation;
import it.nmadlk.models.Vehicle;
import it.nmadlk.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value = "Search vehicles by make")
    @RequestMapping(method = RequestMethod.GET, value="/vehicles/make/{make}", produces="application/json")
    public List<Vehicle> searchByVehicleMake(@PathVariable String make){
        return searchService.searchByVehicleMake(make);
    }

    @ApiOperation(value = "Search vehicles by model")
    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/model/{model}", produces="application/json")
    public List<Vehicle> searchByVehicleModel(@PathVariable String model){
        return searchService.searchByVehicleModel(model);
    }

    @GetMapping(value = "/vehicles/all", produces="application/json")
    public List<Vehicle> searchAll(){
        return searchService.searchAll();
    }

    @ApiOperation(value = "Search all vehicles by make and model")
    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/all/multi/{text}", produces = "application/json")
    public List<Vehicle> searchAllMultiParams(@PathVariable String text){
        return searchService.searchAllMultiParams(text);
    }
}

