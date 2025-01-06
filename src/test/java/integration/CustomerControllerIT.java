package integration;


import com.pizzaorder.dto.response.CustomerResponseDto;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class CustomerControllerIT extends BaseIT {

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

        CustomerResponseDto customerResponseBody = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/customer/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(CustomerResponseDto.class, ObjectMapperType.GSON);

        Assertions.assertNotNull(customerResponseBody.id());
        Assertions.assertEquals("Jane Doe",customerResponseBody.name());
        Assertions.assertEquals("This street that street",customerResponseBody.address());
    }
}
