package org.northcoders.fakerapi.model;

public record Book(int id, String title, String author, String genre, String description) {
    //already makes the attributes/constructor, also getters but no setters.
}
