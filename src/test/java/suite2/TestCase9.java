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

public class TestCase9 extends TestCase8{
    @Test(priority = 4, dependsOnMethods = {"validatePostResponseSuper","validateGetResponseSuper"})
    public void validateDeleteResponseSuper(){
       requester.deleteRequest("user/"+ key_username)
                .then().statusCode(200);
    }

    @Test(priority = 5, dependsOnMethods = {"validateDeleteResponseSuper"})
    public void validateGetResponse() {
        requester.getRequest("user/" + key_username)
                .then().statusCode(404);
    }
}
