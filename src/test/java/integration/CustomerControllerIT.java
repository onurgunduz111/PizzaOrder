package integration;

import com.pizzaorder.Application;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(classes = Application.class,webEnvironment = RANDOM_PORT)
public class CustomerControllerIT {

    @LocalServerPort
    private Integer port;


    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost/api/";
    }

    @Test
    public void givenCustomerURIthenVerifyResponse() {
        RestAssured.given().get("/customer/")
                .then()
                .statusCode(200);
    }

    @Test
    public void givenCustomerURIthenVerifyCreateCustomerRespone() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Jane Doe");
        requestBody.put("address", "This street that street");

        String responseBody = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/customer/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        Assertions.assertTrue(responseBody.contains("id"));
    }
}
