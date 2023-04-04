package com.car.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.models.Car;
import com.car.api.dto.CarDTO;
import com.car.api.repositories.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid CarDTO body) {
        System.out.println(body.modelo());
        System.out.println(body.dataFabricacao());
        repository.save(new Car(body));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO body) {
        repository.findById(id).map(car -> {
            car.setModelo(body.modelo());
            car.setFabricante(body.fabricante());
            car.setDataFabricacao(body.dataFabricacao());
            car.setAnoModelo(body.anoModelo());
            car.setValor(body.valor());
            return repository.save(car);
        });
    }
}
