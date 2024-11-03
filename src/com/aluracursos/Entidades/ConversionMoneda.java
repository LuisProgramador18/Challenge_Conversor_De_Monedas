package com.aluracursos.Entidades;

import java.util.Map;

public record ConversionMoneda(String base_code,
                               Map<String, Double> conversion_rates) {
}
