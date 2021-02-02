package suite;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;
import services.DataGen;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;
import static services.ResponseUtils.responsePostValid;

/*
 * Повторение TC1, тело изменено с файла на объект типа Hashmap
 * с рандомной информацией
 *
 *  Формируется map с рандомной data,
 * сравнение значений ключей отправлнной data
 * и полученного ответа
 */

public class TestCase7 {
    HashMap map = new HashMap();
    BaseClassTest requester = new BaseClassTest();
    JsonPath response;
    String key="username";

    @BeforeClass
    public void createPostData() {
        map.put("name", DataGen.getName());
        map.put("username", DataGen.getUsername());
        map.put("email", DataGen.getEmail());
    }

    @Test(priority = 1)
    public void validateResponsePostWithMapBody() {
        response = responsePostValid(requester.postRequest(map, "users"))
                .extract().jsonPath();
    }

    @Test(priority = 2, dependsOnMethods = {"validateResponsePostWithMapBody"})
    public void chekBodies() {
        assertThat(response.getString(key)).isEqualTo(map.get(key));
    }
}
