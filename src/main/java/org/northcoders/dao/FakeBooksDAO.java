package org.northcoders.dao;

import org.northcoders.common.Locale;
import org.northcoders.model.Response;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class FakeBooksDAO {
    private WebClient client;

    public FakeBooksDAO() {
        client = WebClient.create("https://fakerapi.it");
    }

    public Response getAllBooks() {
        Response response = this.client.get()
                .uri("/api/v1/books").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Response.class)
                .block();

        return response;
    }

    public Response getAllBooks(int limit) {
        Response response = this.client.get()
                .uri((uriBuilder) -> uriBuilder
                        .path("/api/v1/books/")
                        .queryParam("_quantity", limit)
                        .build()
                )
                .retrieve() // send the request
                .bodyToMono(Response.class) // transform raw response into Mono<Response> class object
                .block(); // transforms Mono<Response> into an actual Response class object

        return response;
    }

    public Response getAllBooks(Locale locale) {
        Response response = this.client.get()
                .uri((uriBuilder) -> uriBuilder
                        .path("/api/v1/books/")
                        .queryParam("_locale", locale)
                        .build()
                )
                .retrieve()
                .bodyToMono(Response.class)
                .block();

        return response;
    }


}