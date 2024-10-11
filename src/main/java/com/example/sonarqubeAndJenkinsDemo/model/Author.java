package com.example.sonarqubeAndJenkinsDemo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Author {

    private String name;
    private Character gender;

}