package com.revature.poc_lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class AppHandler implements RequestStreamHandler {

    private static final Gson mapper = new GsonBuilder().setPrettyPrinting().create();
    private final UserRepository userRepo = new UserRepository();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        LambdaLogger logger = context.getLogger();

        try (BufferedReader reqReader = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter respWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII)))
        ) {

            HashMap reqBody = mapper.fromJson(reqReader, HashMap.class);
            logger.log("RECEIVED REQUEST BODY: " + reqBody.toString());

            List<AppUser> payload = userRepo.findAllUsers();
            respWriter.write(mapper.toJson(payload));
            if (respWriter.checkError()) {
                logger.log("WARNING: Writer encountered an error.");
            }

        } catch (Exception e) {
             logger.log("FATAL: " + e);
        }

    }

}
