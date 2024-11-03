package com.aluracursos.Entidades;

import Token.TokenAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoneda {

    public ConversionMoneda convetirMonto(String monedaOrigen){

        String enlace = "https://v6.exchangerate-api.com/v6/"+ TokenAPI.getToken()+"/latest/"+monedaOrigen;
        URI enlaceAPI = URI.create(enlace);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(enlaceAPI)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), ConversionMoneda.class);
    }

    public void logicaConversion(String monedaAConvertir, Float monto, ConversionMoneda conversion){
        double rateConversion = conversion.conversion_rates().get(monedaAConvertir);
        double montoConvertido = rateConversion * monto;
        System.out.println("Convertir " + monto + " "+ conversion.base_code() + " a "+ monedaAConvertir +" equivale a: "+ montoConvertido+" "+ monedaAConvertir);
    }


}
