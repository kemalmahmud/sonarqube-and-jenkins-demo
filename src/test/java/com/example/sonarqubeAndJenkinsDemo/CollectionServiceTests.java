package com.example.sonarqubeAndJenkinsDemo;

import com.example.sonarqubeAndJenkinsDemo.Service.CollectionService;
import com.example.sonarqubeAndJenkinsDemo.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CollectionServiceTests {

	@Autowired
	private CollectionService collectionService;

	@Test
	void checkAuthorCollection() {
		Author author = Author.builder()
				.name("Agatha Christie")
				.gender('F')
				.build();

		List<Book> books = List.of(
				Book.builder().name("The Mysterious Affair at Styles").year(1920).build(),
				Book.builder().name("The Secret Adversary").year(1922).build(),
				Book.builder().name("The Murder on the Links").year(1923).build());

		Collection authorCollection = collectionService.authorCollection(author, books);

		Assertions.assertSame(author.getName(), authorCollection.getAuthor().getName());
		Assertions.assertSame(author.getGender(), authorCollection.getAuthor().getGender());
		Assertions.assertSame(books.get(0).getName(), authorCollection.getBooks().get(0).getName());
		Assertions.assertSame(books.get(0).getYear(), authorCollection.getBooks().get(0).getYear());
		Assertions.assertSame(books.get(1).getName(), authorCollection.getBooks().get(1).getName());
		Assertions.assertSame(books.get(2).getName(), authorCollection.getBooks().get(2).getName());
	}

}
