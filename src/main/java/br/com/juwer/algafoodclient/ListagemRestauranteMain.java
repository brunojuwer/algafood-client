package br.com.juwer.algafoodclient;

import br.com.juwer.algafoodclient.api.ClientApiException;
import br.com.juwer.algafoodclient.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestauranteMain {
    public static void main(String[] args) {
        try {
            var restTemplate = new RestTemplate();
            String URL = "http://localhost:8081";

            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, URL);
            restauranteClient.listar().forEach(System.out::println);
        } catch(ClientApiException e) {
            if(e.getProblem() != null){
                System.out.println(e.getProblem());
                System.out.println(e.getProblem().getUserMessage());
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }

    }
}
