package com.aniketars.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/coffees")
public class RestApiController {

    private List<Coffee> coffeeList = new ArrayList<>();

    public RestApiController(){
        coffeeList.addAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cage Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));
    }

    @GetMapping
    public List<Coffee> getCoffees(){
        return this.coffeeList;
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c: coffeeList){
            if(c.getId().equals(id)) return Optional.of(c);
        }
        return Optional.empty();
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
        coffeeList.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        int coffeeIndex = -1;
        for(Coffee c: coffeeList){
            if(c.getId().equals(id)){
                coffeeIndex = coffeeList.indexOf(c);
                coffeeList.set(coffeeIndex, coffee);
            }
        }
        return coffeeIndex == -1 ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffeeList.removeIf(c -> c.getId().equals(id));
    }
}
