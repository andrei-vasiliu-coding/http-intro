package org.northcoders.model;

import java.util.List;

public record Response(List<Book> data) {
    //name must be the same as the array in postman
}
