package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestAssuredProject {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int id = 0;
    String sshKey = "";

    @BeforeClass
    public void setUp() {
        //Request Specification
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.github.com/user/keys").
                addHeader("Content-Type", "application/json").
                setAuth(oauth2("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")).build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder().
                         expectResponseTime(lessThan(5000L)).build();
    }

    @Test(priority = 1)
    public void postRequestTest(){
        //Request Body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKcmnEyi+tuJFznoPIfq+HyCgyiyXc9gEWCQbj4LmqdD");

        //Send the request and save the response
        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();

        //Extract id from response
        id = response.then().extract().path("id");

        //Assertions
        response.then().spec(responseSpec).statusCode(201).body("title", equalTo("TestAPIKey"));
    }

    @Test(priority = 2)
    public void getRequestTest(){
        given().spec(requestSpec).pathParam("keyId", id).
                when().get("/{keyId}").then().
                spec(responseSpec).statusCode(200).body("title", equalTo("TestAPIKey"));
    }

    @Test(priority = 3)
    public void deleteRequestTest(){
        given().spec(requestSpec).pathParam("keyId", id).
                when().delete("/{keyId}").then().
                spec(responseSpec).statusCode(204);
    }
}
