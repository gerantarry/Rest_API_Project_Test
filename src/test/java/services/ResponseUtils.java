package services;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ResponseUtils {
    public static ValidatableResponse responsePostValid(Response response) {
        return response
                .then()
                .statusCode(201);
    }

    public static ValidatableResponse responseGetValid(Response response){
        return response
                .then()
                .statusCode(200);

    }

}
