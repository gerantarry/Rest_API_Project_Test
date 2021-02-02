package suite2;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;
import java.util.HashMap;

/*
* Цель: проверка передачи невалидного типа данных (int в string)
*
* Подготовка: подготовить данные к отправке (map)
*
* 1. отправить post с типом int в ячейке типа string
*
* ОР: в теле ответа придёт статус код ошибки.
* ФР: тип сконвертировался из int в string, статус код 200
 */

//TODO правильно определить условия выполнения теста

public class TestCase13 {
    BaseClassTest requester = new BaseClassTest();
    HashMap map = new HashMap();

    @BeforeClass
    public void createPostData() {
        requester.setURI("https://petstore.swagger.io/v2/");
        map.put("username", "types_test");
        map.put("firstName", 5367);
        map.put("id", 999666);
    }

    @Test(priority = 11)
    public void validatePostResponse() {
      Response response = requester.postRequest(map, "user")
                .then().extract().response();
        Assertions.assertThat(response.statusCode()).isNotEqualTo(200);
    }
}

