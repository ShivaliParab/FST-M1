package activities;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.Method.POST;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //Headers
    Map<String,String> headers = new HashMap<>();

    //Resource path
    String resourcePath = "/api/users";
    //Make a contract
    @Pact(consumer="UserConsumer",provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        //Set the headers
        headers.put("Content-Type","application/json");

        //Set the Request and Response body
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id",123)
                .stringType("firstName", "Shivali")
                .stringType("lastName", "Parab")
                .stringType("email", "shivaliparab@gmail.com");

                return builder.given("create user request").
                        uponReceiving("a request to create a user").
                        method("POST").
                        headers(headers).
                        path(resourcePath).
                        body(requestResponseBody).
                        willRespondWith().
                        status(201).
                        body(requestResponseBody).toPact();
    }
    //Test with Provider Mock
    @Test
    @PactTestFor(providerName="UserProvider", port="8282")
        public void postRequestTest() {
            // Request Body
            Map<String, Object> reqBody = new HashMap<>();
            reqBody.put("id", 123);
            reqBody.put("firstName", "Shivali");
            reqBody.put("lastName", "Parab");
            reqBody.put("email", "shivaliparab@gmail.com");

            // Send post request
            given().baseUri("http://localhost:8282").headers(headers).body(reqBody).
                    when().post(resourcePath).
                    then().statusCode(201);
        }

}
