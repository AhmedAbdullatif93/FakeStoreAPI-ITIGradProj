package tests;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateProduct extends BaseTest{

    @Test
    public void testUpdateProduct(ITestContext context) {
        // Retrieve the "id" attribute from the suite context
        Object idObject = context.getSuite().getAttribute("id");

        // Check if the attribute is not null before casting it to int
        if (idObject != null) {
            int id = (int) idObject;

            // Use the retrieved id in your test logic
            Response response = given()
                    .spec(requestSpecification)
                    .pathParams("id", id)
                    .body(requestPayloads.setToUpdateProductPayload())
                    .when()
                    .put(APIConstants.updateProduct);

            assertActions.verifyStatusCode(response);
            assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "title"), "Yoda Sneakers", "The value title is not updated.");
            assertActions.verifyResponseBody(apiActions.getDataFromJsonPath(response, "price"), 550, "The price is not updated.");

            System.out.println(response.body().prettyPeek());
        } else {
            // Handle the case when the "id" attribute is not set
            System.out.println("The 'id' attribute is not set in the suite context.");
        }
    }
    }
