package suite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;

/*
 * Цель: проверка отправки нескольких
 * значений в одном поле.
 *
 * Подготовка: указать путь к файлу data3.json
 *
 * 1. выполнить post запрос
 *
 * ОР: должна быть ошибка (тут сложно судить, тк документация неподробная на сайте)
 * ФР: запись добавлена с последним значением в ключа email из файла.
 * */

public class TestCase11 {
    BaseClassTest requester = new BaseClassTest();
    String key_username = "Gerrantary";

    @BeforeClass
    public void setup() {
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("C:\\Users\\Gerant\\IdeaProjects\\Rest_API_Project_Test\\" +
                "src\\main\\resources\\data3.json");
    }

    @Test(priority = 8)
    public void validatePostResponse(){
        requester.postRequest("user")
                .then().statusCode(200);
    }
}
