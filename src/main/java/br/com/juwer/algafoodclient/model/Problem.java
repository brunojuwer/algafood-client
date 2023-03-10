package br.com.juwer.algafoodclient.model;

import lombok.Data;

import java.time.OffsetDateTime;
@Data
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String userMessage;
}
