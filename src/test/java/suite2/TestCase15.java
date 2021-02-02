package suite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;

import static io.restassured.RestAssured.when;

/*
 * Цель: проверить delete при удалении несущ. записи
 *
 * Подготовка: выполнить TC8, TC9;
 *
 * 1.выполнить delete запрос по username
 *
 * ОР: 404 NotFound
 * */

public class TestCase15{

    BaseClassTest requester = new BaseClassTest();
    String username = "Gerrantary";

    @BeforeClass()
    public void setup() {
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("C:\\Users\\Gerant\\IdeaProjects\\Rest_API_Project_Test\\" +
                "src\\main\\resources\\data2.json");
    }

    @Test(priority = 16)
    public void validateDeleteResponse(){
        String log = when().delete("user/"+ username)
                .then().statusCode(404).log().all().toString();
        System.out.println(log);
    }

}
