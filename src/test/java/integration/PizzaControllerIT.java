package integration;

import com.pizzaorder.Application;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = Application.class,webEnvironment = RANDOM_PORT)
public class PizzaControllerIT {

    @LocalServerPort
    private Integer port;


    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost/api/";
    }

    @Test
    public void givenPizzaURIthenVerifyResponse() {
        RestAssured.given().get("/pizza/")
                .then()
                .statusCode(200);
    }
}
