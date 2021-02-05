package suite2;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.BaseClassTest;
import static org.assertj.core.api.Assertions.assertThat;
import static services.ResponseUtils.responseGetValid;

/*
*               petstore.swagger.io
*
* Цель: удостовериться в появлении информации на сервере
*
* Подготовка: установить URI, и путь к data2.json
*
* 1.отправить post на endp. user
* 2.отправить get на endp. user/+ username(п.1)
* 3.сравнить значения из п.1 и п.2 в respons'ах
*
* ОР: все сравниваемые значения равны
*/

public class TestCase8 {
   public BaseClassTest requester = new BaseClassTest();
    JsonPath response1=null,response2=null;
    int key_id = 195674;
   public String key_username = "Gerrantary", key_firstname ="Ant";

    @BeforeClass
    public void setup(){
        requester.setURI("https://petstore.swagger.io/v2/");
        requester.setJsonDataPath("src/test/resources/data2.json");
    }

    @Test(priority = 1)
    public void validatePostResponseSuper(){
       response1 = requester.postRequest("user")
                .then().statusCode(200).extract().jsonPath();
    }

    @Test(priority = 2, dependsOnMethods = {"validatePostResponseSuper"})
    public void validateGetResponseSuper(){
        response2 = responseGetValid(requester
               .getRequest("user/"+key_username)).extract().jsonPath();
        System.out.println(response2);
    }

    @Test(priority = 3, dependsOnMethods = {"validateGetResponseSuper"})
    public void checkValues(){
        assertThat(response1.getString(String.valueOf(key_id)))
                .isEqualTo(response2.get(String.valueOf(key_id)));
        assertThat(response1.getString(key_username)).isEqualTo(response2.get(key_username));
        assertThat(response1.getString(key_firstname)).isEqualTo(response2.get(key_firstname));
    }
}
