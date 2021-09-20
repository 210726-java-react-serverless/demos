package com.revature.get_books;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetBooksHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final Gson mapper = new GsonBuilder().setPrettyPrinting().create();
    private final DynamoDBMapper dbReader = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {

        LambdaLogger logger = context.getLogger();
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

        logger.log("RECEIVED EVENT: " + requestEvent);

        Map<String, String> queryParams = requestEvent.getQueryStringParameters();

        if (queryParams == null || queryParams.isEmpty()) {
            responseEvent.setBody(mapper.toJson(getAllBooks()));
            return responseEvent;
        }

        responseEvent.setBody(mapper.toJson(searchBooks(queryParams, logger)));
        return responseEvent;

    }




    public List<Book> getAllBooks() {
        return dbReader.scan(Book.class, new DynamoDBScanExpression());
    }

    @SneakyThrows
    public List<Book> searchBooks(Map<String, String> queryParams, LambdaLogger logger) {

        StringBuilder filterExprBuilder = new StringBuilder();
        Map<String, AttributeValue> attributeValues = new HashMap<>();
        List<String> paramKeys = new ArrayList<>(queryParams.keySet());
        List<String> bookFieldNames = Book.getFieldNameStrings();

        for (int i = 0; i < paramKeys.size(); i++){

            filterExprBuilder.append("(");
            if (i != 0) filterExprBuilder.append(" and ");

            String paramKey = paramKeys.get(i);

            if (!bookFieldNames.contains(paramKey)) {
                throw new RuntimeException("The field, " + paramKey + ", was not found on resource type: Book");
            }

            String fieldType = Book.class.getDeclaredField(paramKey).getType().getSimpleName();
            String paramVal = Optional.ofNullable(queryParams.get(paramKey))
                                      .orElseThrow(() -> new RuntimeException("Unexpected null value found in parameter map."));


            switch (fieldType) {
                case "String":

                    String attributeKeyVar = ":" + paramKey;
                    filterExprBuilder.append(paramKey).append(" = ").append(attributeKeyVar);
                    attributeValues.put(attributeKeyVar, new AttributeValue().withS(paramVal));

                    break;

                case "List":

                    // If there is only one provided query value
                    if (!paramVal.contains(",")) {

                        String attrKey = ":" + paramKey;
                        filterExprBuilder.append("contains(").append(paramKey).append(",").append(attrKey).append(")");
                        attributeValues.put(attrKey, new AttributeValue().withS(paramVal));

                    } else {

                        String[] listVals = paramVal.split(",");

                        for (int j = 0; j < listVals.length; j++) {
                            String key = ":" + paramKey + j;
                            filterExprBuilder.append("contains(").append(paramKey).append(",").append(key).append(")");
                            if (j != listVals.length - 1) filterExprBuilder.append(" or ");
                            attributeValues.put(key, new AttributeValue().withS(listVals[j]));
                        }
                    }

                    break;
            }

            filterExprBuilder.append(")");

        }

        logger.log("{\n" +
                "\t\"filterExpression\": \"" + filterExprBuilder + "\"," +
                "\t\"attributeValues\": \"" + attributeValues + "\"" +
                "\n}");

       DynamoDBScanExpression scanExpr = new DynamoDBScanExpression()
               .withFilterExpression(filterExprBuilder.toString())
               .withExpressionAttributeValues(attributeValues);

        return dbReader.scan(Book.class, scanExpr);

    }

    @Data
    @DynamoDBTable(tableName = "books")
    public static class Book {

        @DynamoDBHashKey
        @DynamoDBAutoGeneratedKey
        private String id;

        @DynamoDBAttribute
        private String isbn;

        @DynamoDBAttribute
        private String title;

        @DynamoDBAttribute
        private String publisher;

        @DynamoDBAttribute
        private List<String> authors;

        @DynamoDBAttribute
        private List<String> genres;

        public static List<String> getFieldNameStrings() {
            return Stream.of(Book.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
        }

    }

}
