package suite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;
import services.DataGen;

import java.util.HashMap;

/*
* Цель: не отправить обязательный параметр (id)
*
* Подготовка: подготовить данные для отправки в методе post
*
* 1. post запрос без username
* 2. get запрос с фильтром поиска по firstName
*
* ОР: ошибка 405
* (т.к. username нету, то нельзя организовать поиск по этому атрибуту
* я решил произвести поиск по известном атрб.)
* */

//TODO написать утверждение что тест пройден
public class TestCase12 {
    BaseClassTest requester = new BaseClassTest();
    HashMap map = new HashMap();

    @BeforeClass
    public void createPostData() {
        requester.setURI("https://petstore.swagger.io/v2/");
        map.put("firstName", 5367);
        map.put("email", DataGen.getEmail());
    }

    @Test(priority = 9)
    public void validatePostResponse(){
        requester.postRequest(map,"user")
                .then().statusCode(200);
    }

    @Test(priority = 10, dependsOnMethods = {"validatePostResponse"})
    public void validateGetResponse(){
        requester.getRequest("user?firstName=VanDark")
                .then().statusCode(405);
    }
}
