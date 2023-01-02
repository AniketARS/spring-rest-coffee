package com.aniketars.restapi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@Entity
class Coffee {

    @Id
    private String id;
    private String name;

    public Coffee() {}

    public Coffee(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

interface CoffeeRepository extends CrudRepository<Coffee, String> {}