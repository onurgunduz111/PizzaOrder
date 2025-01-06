package integration;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class PizzaControllerIT  extends BaseIT{


    @Test
    public void givenPizzaURIthenVerifyResponse() {
        RestAssured.given().get("/pizza/")
                .then()
                .statusCode(200);
    }
}
