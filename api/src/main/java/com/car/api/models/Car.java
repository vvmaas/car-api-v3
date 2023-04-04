package com.car.api.models;

import java.util.Date;

import com.car.api.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarDTO data) {
        this.modelo = data.modelo();
        this.fabricante = data.fabricante();
        this.dataFabricacao = data.dataFabricacao();
        this.valor = data.valor();
        this.anoModelo = data.anoModelo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String modelo;

    @Column(length = 30, nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private String dataFabricacao;

    @Column(nullable = false)
    private int valor;

    @Column(nullable = false)
    private int anoModelo;
}
