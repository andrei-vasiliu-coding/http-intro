package org.northcoders.dao;

import org.northcoders.model.Response;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class FakeBooksDAO {

    public static Response getAllBooks() {

        WebClient client = WebClient.create("https://fakerapi.it");

        Response result = client.get()
                .uri("/api/v1/books").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Response.class)
                .block();

        return result;
    }

}