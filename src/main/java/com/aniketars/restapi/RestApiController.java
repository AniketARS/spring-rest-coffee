package com.aniketars.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/coffees")
public class RestApiController {

    private final CoffeeRepository coffeeRepository;

    public RestApiController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    public Iterable<Coffee> getCoffees(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id){
        return coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee){
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        return coffeeRepository.existsById(id) ?
                new ResponseEntity<>(coffee, HttpStatus.OK) :
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffeeRepository.deleteById(id);
    }
}
