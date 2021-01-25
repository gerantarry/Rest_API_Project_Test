package services;

import io.restassured.response.Response;

public class ResponseUtils{

    public static void RespOut(Response response) {
        if (response!=null){
            String JsonAsString = response.getBody().asString();
            System.out.println("ПРОВЕРКА: \n" + JsonAsString);}
        else System.out.println("ПРОВЕРКА: пустое поле ответа");
    }

    }

