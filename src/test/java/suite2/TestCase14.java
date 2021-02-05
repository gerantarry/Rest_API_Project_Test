package suite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;
import java.util.HashMap;

/*
 * Цель: сделать 2 post запроса с одинаковым id
 *
 * Подготовка: подготовить данные в объектах map1,map2
 *
 * 1. сделать post запрос с телом map1
 * 2. сделать post запрос с телом map2
 * 3. сделать get запрос по username1
 * 4. сделать get запрос по username2
 *
 * ОР: запрос по username1 - 404 NotFound
 *     запрос по username2 - 200 Ok
 * */

public class TestCase14 {
    BaseClassTest requester = new BaseClassTest();
    HashMap map1 = new HashMap();
    HashMap map2 = new HashMap();
    String username1 = "TestingId";
    String username2 = "TestingId_2";

    @BeforeClass
    public void createPostData() {
        requester.setURI("https://petstore.swagger.io/v2/");
        map1.put("username", username1);
        map1.put("id", 777222);
        map2.put("username", username2);
        map2.put("id", 777222);
    }

    @Test(priority = 12)
    public void validatePostResponse() {
        requester.postRequest(map1, "user")
                .then().statusCode(200);
    }

    @Test(priority = 13)
    public void validatePostResponse2() {
        requester.postRequest(map2, "user")
                .then().statusCode(200);
    }

    @Test(priority = 14, dependsOnMethods = {"validatePostResponse"})
    public void validateGetResponse() {
        requester.getRequest("user/" + username1)
                .then().statusCode(404);
    }

    @Test(priority = 15, dependsOnMethods = {"validatePostResponse2"})
    public void validateGetResponse2() {
        requester.getRequest("user/" + username2)
                .then().statusCode(200);
    }
}


