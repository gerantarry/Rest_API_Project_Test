package suite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;

/*
* Цель: обновить через put несуществующую запись
*
* Подготовка
*
* 1. delete запрос по key_username
* 2. put запрос по key_username
*
*
* ОР: 404 User Not Found
* ФР: 200 ОК, обновляет несуществующее
* */

public class TestCase16 {
    public String key_username = "Gerrantary";
    public BaseClassTest requester = new BaseClassTest();

    @BeforeClass
    public void setup() {
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("src/test/resources/data4.json");
    }

    @Test(priority = 4)
    public void validateDeleteResponseSuper(){
        requester.deleteRequest("user/NEW"+ key_username)
                .then().statusCode(200);
    }

    @Test(priority = 6)
    public void validatePutResponse(){
        String log = requester.putRequest("user/NEW"+key_username)
                .then().statusCode(404).log().all().toString();
        System.out.println(log);
    }
}
