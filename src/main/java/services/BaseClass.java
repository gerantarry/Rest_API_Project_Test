package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static io.restassured.RestAssured.*;

public class BaseClass extends endpointConstans{
    //вспомогательные методы
        public static void setURI (String uri){
        URI = uri;
    }

        public static void setCookie (String cookie){
        COOKIE = cookie;
    }

        public static void setJsonDataPath (String jsonDataPath){
        JSON_DATA_PATH= jsonDataPath;
    }

        public static String getJsonDataPath(){return JSON_DATA_PATH;}

        public static FileInputStream getJsonData(){
            FileInputStream JSON_DATA = null;
        try {
                JSON_DATA = new FileInputStream(JSON_DATA_PATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return JSON_DATA;
    }


    //методы request
    public static Response getRequest(String endpoint){
        return when().get(URI+endpoint);
    }

    public static Response postRequest(String endpoint){

       return given().
               contentType(ContentType.JSON).
                when().
                body(getJsonData()).post(URI+endpoint);
    }

}




