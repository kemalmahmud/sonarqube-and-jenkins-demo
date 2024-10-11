package com.example.sonarqubeAndJenkinsDemo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book {

    private String name;
    private Integer year;

}
