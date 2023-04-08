package Tests;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class TestsExamples {
    @Test
    public void test1(){
        Response response = get("https://reqres.in/api/users?page=2");
//        System.out.println(response.getStatusCode());
//        System.out.println(response.getTime());
//        System.out.println(response.getBody().asString());
//        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(response.getStatusCode(),204, "First ");
        System.out.println(response.getHeader("content-type"));
        assertEquals(response.getStatusCode(), 200);
        soft.assertEquals(response.getStatusCode(),204, "Second");
        soft.assertAll();


    }
    @Test
    public void test2(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[0].id", equalTo(7)).
                log().all();
    }
}