package suite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;

/*
 * Подготовка: Выполнить TC8, установить путь к data4.json
 *
 * 1. put username
 * 2. проверить запись username
 *
 * ОР: status code 200 OK, запись изменила username и id
 * */

// поле id внешний ключ, при изменении в пут id, создаётся новая запись, а не редактируется старая

public class TestCase10{
    public String key_username = "Gerrantary";
    public BaseClassTest requester = new BaseClassTest();

    @BeforeClass
    public void setup() {
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("src/test/resources/data4.json");
    }

    @Test(priority = 6)
    public void validatePutResponse(){
        String log = requester.putRequest("user/NEW"+key_username)
                .then().statusCode(200).log().all().toString();
        System.out.println(log);
    }

    @Test(priority = 7, dependsOnMethods = {"validatePutResponse"})
    public void validateGetResponse() {
        requester.getRequest("user/" + "NEW" + key_username)
                .then().statusCode(200);
    }
}
