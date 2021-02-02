package suite;

import org.testng.annotations.Test;
import services.BaseClassTest;
import static services.ResponseUtils.responseGetValid;
import static org.hamcrest.Matchers.*;

/*
 * Цель: проверка get запроса
 *
 * 1. отправить get на endp. posts?userId=10
 * 2. отыскать запись с id = 91.
 *
 * ОР: тест пройден если запись найдена
 */

public class TestCase2 {
    BaseClassTest requester = new BaseClassTest();

    @Test
    public void validateResponseGetHasItem() {
       responseGetValid(requester.getRequest("userId",10,"posts"))
       .assertThat().body("id",hasItem(91));
    }
}
