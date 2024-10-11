package com.example.sonarqubeAndJenkinsDemo.Service;

import com.example.sonarqubeAndJenkinsDemo.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    public Collection authorCollection(Author author, List<Book> books) {
        return new Collection(author, books);
    }

}
