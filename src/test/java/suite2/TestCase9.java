package suite2;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;

import static io.restassured.RestAssured.when;

/*
* Подготовка: Выполнить TC8
*
* 1. сделать запрос delete $username
* 2. отправить get запрос проверить наличие $username
*
* ОР: ошибка 404 notFound
* */

public class TestCase9 {
    BaseClassTest requester = new BaseClassTest();
    String key_username = "Gerrantary";

    @BeforeClass
    public void setup(){
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("C:\\Users\\Gerant\\IdeaProjects\\Rest_API_Project_Test\\" +
                "src\\main\\resources\\data2.json");
    }


    @Test(priority = 4)
    public void validateDeleteResponseSuper(){
       when().delete("user/"+ key_username)
                .then().statusCode(200);
    }

    @Test(priority = 5, dependsOnMethods = {"validateDeleteResponseSuper"})
    public void validateGetResponse() {
        requester.getRequest("user/" + key_username)
                .then().statusCode(404);
    }
}
