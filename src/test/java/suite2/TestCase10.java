package suite2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import services.BaseClassTest;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/*
 * Подготовка: Выполнить TC8,
 *
 * 1. put username
 * 2. проверить запись username
 *
 * ОР: status code 200 OK, запись изменила username и id
 * */
//TODO поле id внешний ключ, при изменении в пут id, создаётся новая запись, а не редактируется старая
//FIXME метод ПУТ не проходит
public class TestCase10 {
    BaseClassTest requester = new BaseClassTest();
    String key_username = "Gerrantary";

    @BeforeClass
    public void setup() {
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("C:\\Users\\Gerant\\IdeaProjects\\Rest_API_Project_Test\\" +
                "src\\main\\resources\\data2.json");
    }

    @Test(priority = 6)
    public void validatePutResponse(){
        String log = given()
                .params("username",("NEW" + key_username),
                "id","23773")
                .when()
                .put("user/"+ key_username)
                .then().statusCode(200).log().all().toString();
        System.out.println(log);
    }

    @Test(priority = 7, dependsOnMethods = {"validatePutResponse"})
    public void validateGetResponse() {
        requester.getRequest("user/" + "NEW" + key_username)
                .then().statusCode(200);
    }
}
