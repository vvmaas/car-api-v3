package com.car.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarDTO(
  
@NotBlank
@NotNull
String modelo, 

@NotBlank
@NotNull
String fabricante,

@NotBlank
@NotNull
String dataFabricacao,

@NotNull
int valor,

@NotNull
int anoModelo) {
    
}
