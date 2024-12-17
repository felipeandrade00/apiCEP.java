package org.aplicacao.servico;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aplicacao.dto.EnderecoDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIservico {

    EnderecoDTO enderecoDTO = new EnderecoDTO();

    public EnderecoDTO getEndereco(String cep) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/"+ cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper =  new ObjectMapper();
            enderecoDTO = mapper.readValue(response.body(), EnderecoDTO.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return enderecoDTO;

    }

}
