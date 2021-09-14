package com.revature.get_books;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookRepository {

    private final DynamoDBMapper dbReader;

    public BookRepository() {
        dbReader = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());
    }

    public List<Book> getAllBooks() {
        return dbReader.scan(Book.class, new DynamoDBScanExpression());
    }

    public Optional<Book> getBookByIsbn(String isbn) {

        Map<String, AttributeValue> queryInputs = new HashMap<>();
        queryInputs.put(":isbn", new AttributeValue().withS(isbn));

        DynamoDBScanExpression query = new DynamoDBScanExpression()
                .withFilterExpression("isbn = :isbn")
                .withExpressionAttributeValues(queryInputs);

        List<Book> queryResult = dbReader.scan(Book.class, query);

        return queryResult.stream().findFirst();

    }

}
