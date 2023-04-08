package Tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class GetAndPostExamples {
    @Test
   public void testGet(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name",hasItems("George", "Rachel"));
    }

    @Test
    public void testPost(){
        JSONObject request = new JSONObject();
        request.put("name", "Dhananjai");
        request.put("job","Tester");

        baseURI = "https://reqres.in/api";
        given().
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201);
}





}
