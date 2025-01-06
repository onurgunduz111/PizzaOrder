package integration;

import com.pizzaorder.Application;
import com.pizzaorder.dto.OrderPizzaDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.*;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = Application.class,webEnvironment = RANDOM_PORT)
public class OrderControllerIT {
    @LocalServerPort
    private Integer port;


    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost/api/";
    }

    @Test
    public void givenOrderURIthenVerifyCreateOrderRespone() {
        List<OrderPizzaDto> orderPizzaDtoList = new ArrayList<OrderPizzaDto>();
        orderPizzaDtoList.add(new OrderPizzaDto(UUID.fromString("d844062f-1669-4c0c-ae5e-91d47f9e5280"),2));

        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("customerId", "048efa83-ccab-4e44-b571-761ebcfb0545");
        requestBody.put("orderPizzas", orderPizzaDtoList);

        String responseBody = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/order/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        Assertions.assertTrue(responseBody.contains("id"));
    }
}
