package suite;

import org.testng.annotations.Test;
import services.BaseClassTest;
import static org.hamcrest.Matchers.equalTo;
import static services.ResponseUtils.responsePostValid;

/*
 *                  JSPH.
 *
 * Цель: проверка post запроса.
 *
 * Подготовка: подготовить файл data.json;
 *
 * 1.Отправляем post на endp. posts;
 * 2.Проверяем title и body в теле ответа
 *
 * ОР: title и body совпадают с теми что в файле.
 */

public class TestCase1 {
    BaseClassTest requester = new BaseClassTest();

    @Test
    public void validateResponsePost() {
        responsePostValid(requester.postRequest(""))
                .body("title", equalTo("proverka_title"))
                .and()
                .body("body", equalTo("proverka_body"));
    }
}
