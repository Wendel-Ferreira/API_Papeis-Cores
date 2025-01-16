package com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Encadernacao;

import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Encadernacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class HttpEncadernacao {

    private static final String urlFindAllEncadernacao = "http://localhost:8080/api/encadernacao/findAll";

    private static final String urlAddEncadernacao = "http://localhost:8080/api/encadernacao/save";

    public List<Encadernacao> findAll() throws Exception {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlFindAllEncadernacao))
                    .GET().build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), new TypeReference<List<Encadernacao>>() {
            });

    }
    public void save (Encadernacao encadernacao){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(encadernacao);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlAddEncadernacao)).header("Content-Type","aplication/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
