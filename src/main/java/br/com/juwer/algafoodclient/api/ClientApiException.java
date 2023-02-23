package br.com.juwer.algafoodclient.api;

import br.com.juwer.algafoodclient.model.Problem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.springframework.web.client.RestClientResponseException;

public class ClientApiException extends RuntimeException {

    static final long serialVersionUID = 1L;

    @Getter
    private Problem problem;

    public ClientApiException(String message, RestClientResponseException cause) {
        super(message, cause);
        this.deserializeProblem(cause);
    }

    public void deserializeProblem(RestClientResponseException cause) {
        var mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();

        try {
            this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problem.class);
        } catch (JsonProcessingException e) {
            System.out.println("Não foi possível desesiarializar a resposta em um tipo Problema");
            e.printStackTrace();
        }
    }
}
