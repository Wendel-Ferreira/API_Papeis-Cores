package com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Insumo;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Insumo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpInsumo {

    private static final String urlFindAllInsumo = "http:/localhost:8080/api/insumo/findAll";

    private static final String urlSaveInsumo = "http:/localhost:8080/api/insumo/save";

    public List<Insumo> httpFindAllInsumo() throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFindAllInsumo)).GET().build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<Insumo>>() {
        });
    }
    public void httpSaveInsumo(Insumo insumo) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(insumo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlSaveInsumo))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
    }
}
