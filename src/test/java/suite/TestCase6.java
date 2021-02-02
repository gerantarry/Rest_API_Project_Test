package suite;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import services.BaseClassTest;

import static org.assertj.core.api.Assertions.assertThat;
import static services.ResponseUtils.responseGetValid;

/*
 * Цель: проверить email на наличие в зарегистрированных
 *
 * 1. сделать 2 валидных get запроса по endp. users/1 и comments;
 * 2. произвести поиск email из тела первого ответа в теле второго ответа
 *
 * ОР: тест пройден, если совпадений нет
 */

public class TestCase6 {
    BaseClassTest requester = new BaseClassTest();
    String key = "email";
    JsonPath response1, response2;

    @Test(priority = 1)
    public void validateResponseGet() {
       response1 = responseGetValid(requester.getRequest("users/1"))
              .extract().jsonPath(); //email: Sincere@april.biz
       response2 = responseGetValid(requester.getRequest("comments"))
                .extract().jsonPath();
        System.out.println(response2.getString(key));
    }

    @Test(priority = 2, dependsOnMethods = {"validateResponseGet"})
    public void DoesntContainEmail(){
        assertThat(response2.getString(key))
                .doesNotContain(response1.getString(key));
    }
}
