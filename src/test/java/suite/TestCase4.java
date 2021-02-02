package suite;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;
import static services.ResponseUtils.responseGetValid;

/*
 * Цель: получение куки и использование их в новом запросе
 *
 * Подготовка: сделать валидный get запрос
 *
 * 1. Достать куки из ответа
 * 2. Сделать новый get запрос с полученными куки
 *
 * ОР: Get успешно прошёл
 */

public class TestCase4 {
    BaseClassTest requester = new BaseClassTest();
    Response response;
    String cookie = null;

    @BeforeClass
    public void ValidateResponseGet() {
        response = responseGetValid(requester.getRequest("posts/2"))
                .extract().response();
    }

    // куки работаю но не знаю для чего они нужны на JSPH
    @Test(priority = 1)
    public void GetCookieFromResponse() {
        cookie = response.getCookie("__cfduid"); //имя куки из postman
        System.out.println(cookie);
        requester.setCookie(cookie);

    }

    @Test(priority = 2, dependsOnMethods = {"GetCookieFromResponse"})
    public void setCookieForRequest(){
        String resp =
                requester.cookieGetRequest("posts/2").toString();
        System.out.println(resp);
    }
}