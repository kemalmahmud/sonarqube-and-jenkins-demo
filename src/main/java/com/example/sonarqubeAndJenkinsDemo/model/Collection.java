package com.example.sonarqubeAndJenkinsDemo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Collection {

    private Author author;
    private List<Book> books;
}