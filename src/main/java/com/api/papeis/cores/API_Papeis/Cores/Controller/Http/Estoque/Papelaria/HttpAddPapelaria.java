package com.api.papeis.cores.API_Papeis.Cores.Controller.Http.Estoque.Papelaria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.api.papeis.cores.API_Papeis.Cores.Model.Estoque.Papelaria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class HttpAddPapelaria {

    private static final String urlBaseFindAll = "http://localhost:8080/api/papelaria/findAll";

    private static final String urlBaseSave = "http://localhost:8080/api/papelaria/save";

    public List<Papelaria> findAll() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlBaseFindAll)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<Papelaria>>() {
        });
    }

    public void savePapelaria(Papelaria papelaria) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(papelaria);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBaseSave))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Produto adicionado com sucesso" + response.body());
        } else {
            System.out.println("Erro ao adicionar o Produto " + response.body());
        }
    }
}
