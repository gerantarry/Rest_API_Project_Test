package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;


public class BaseClassTest extends EndpointConstans {
    //вспомогательные методы
    public void setURI(String uri) {
        baseURI = URI = uri;
    }

    public String getURI(){
        return URI;
    }

    public String getPath(){
        return PATH;
    }

    public void setPath(String path) {
        basePath = PATH = path;
    }

    public void setCookie(String cookie) {
        COOKIE = cookie;
    }

    public void setJsonDataPath(String jsonDataPath) {
        JSON_DATA_PATH = jsonDataPath;
    }

    public String getJsonDataPath() {
        return JSON_DATA_PATH;
    }

    public FileInputStream getJsonData() {
        FileInputStream JSON_DATA = null;
        try {
            JSON_DATA = new FileInputStream(JSON_DATA_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return JSON_DATA;
    }

    private void pathChecker(String endpoint) {
        if (!endpoint.equals(""))
            setPath(endpoint);
    }

    //методы request
    public Response getRequest(String endpoint) {
        pathChecker(endpoint);
        return when()
                .get(URI + PATH);
    }

    public Response cookieGetRequest(String endpoint) {
        pathChecker(endpoint);
        return given()
                .cookie(COOKIE)
                .when()
                .get(URI + PATH);
    }

    public <T extends Object> Response getRequest(String param_name,T param_value, String endpoint) {
        pathChecker(endpoint);
        return given()
                .param(param_name,param_value)
                .when()
                .get(URI + PATH);
    }

    public Response getRequest(RequestSpecification spec, String endpoint) {
        pathChecker(endpoint);
        return given()
                .spec(spec)
                .when()
                .get(URI + PATH);
    }

    public Response postRequest(String endpoint) {
        pathChecker(endpoint);
        return given().
                contentType(ContentType.JSON).
                when().
                body(getJsonData()).
                post(URI + PATH);
    }

    public <T extends Object> Response postRequest(T body, String endpoint){
        pathChecker(endpoint);
        return given().
                contentType(ContentType.JSON).
                when().
                body(body).
                post(URI + PATH);
    }

    public Response deleteRequest(String endpoint){
        pathChecker(endpoint);
        return given()
                .when()
                .delete(URI + PATH);
    }

    public Response putRequest(String endpoint){
        pathChecker(endpoint);
        return given().
                contentType(ContentType.JSON).
                when().
                body(getJsonData()).
                put(URI + PATH);
    }

}
