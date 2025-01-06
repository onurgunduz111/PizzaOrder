package integration;

import com.pizzaorder.dto.OrderPizzaDto;
import com.pizzaorder.dto.response.CustomerResponseDto;
import com.pizzaorder.dto.response.OrderResponseDto;
import com.pizzaorder.dto.response.PizzaResponseDto;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class OrderControllerIT  extends BaseIT{


    @Test
    public void givenOrderURIthenVerifyCreateOrderRespone() {
        CustomerResponseDto customerResponseBody = getCustomerResponseDto();
        PizzaResponseDto pizzaResponseBody = getPizzaResponseDto();

        Map<String, Object> orderRequestBody = new HashMap<String, Object>();
        orderRequestBody.put("customerId", customerResponseBody.id());
        orderRequestBody.put("orderPizzas", List.of(new OrderPizzaDto(pizzaResponseBody.id(), 2)));

        OrderResponseDto orderResponseBody = RestAssured.given()
                .contentType("application/json")
                .body(orderRequestBody)
                .when()
                .post("/order/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(OrderResponseDto.class, ObjectMapperType.GSON);

        Assertions.assertNotNull(orderResponseBody.id());
        Assertions.assertEquals(2,  orderResponseBody.orderPizzas().get(0).amount());
        Assertions.assertNotNull(orderResponseBody.orderPizzas().get(0).pizzaId());
    }

    private PizzaResponseDto getPizzaResponseDto() {
        Map<String, Object> requestBodyPizza = new HashMap<String, Object>();
        requestBodyPizza.put("name", "Mozeralla");
        requestBodyPizza.put("price", 1.25);

        return RestAssured.given()
                .contentType("application/json")
                .body(requestBodyPizza)
                .when()
                .post("/pizza/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(PizzaResponseDto.class, ObjectMapperType.GSON);
    }

    private CustomerResponseDto getCustomerResponseDto() {
        Map<String, Object> customerRequestBody = new HashMap<String, Object>();
        customerRequestBody.put("name", "Jane Doe");
        customerRequestBody.put("address", "This street that street");

        return RestAssured.given()
                .contentType("application/json")
                .body(customerRequestBody)
                .when()
                .post("/customer/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(CustomerResponseDto.class, ObjectMapperType.GSON);
    }
}
