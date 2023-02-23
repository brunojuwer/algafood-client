package br.com.juwer.algafoodclient;

import br.com.juwer.algafoodclient.api.RestauranteClient;
import br.com.juwer.algafoodclient.model.RestauranteResumoModel;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ListagemRestauranteMain {
    public static void main(String[] args) {
        var restTemplate = new RestTemplate();
        String URL = "http://localhost:8081";

        RestauranteClient restauranteClient = new RestauranteClient(restTemplate, URL);
        restauranteClient.listar().forEach(System.out::println);
    }
}
