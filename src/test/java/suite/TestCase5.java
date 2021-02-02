package suite;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import services.BaseClassTest;
import static org.assertj.core.api.Assertions.assertThat;
import static services.ResponseUtils.responseGetValid;

/*
 * Тестирую тоже get, просто игрался с
 * библиотеками для сравнения
 */

public class TestCase5 {
    BaseClassTest requester = new BaseClassTest();
    String expectedValue = "qui est esse";

    @Test
    public void ValidateResponseGetIsEqualTo() {
        JsonPath response = responseGetValid(requester.getRequest("posts/2"))
                .extract().jsonPath();
        assertThat(response.getString("title")).isEqualTo(expectedValue);
    }
}
