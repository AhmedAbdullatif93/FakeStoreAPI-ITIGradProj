package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateProduct extends BaseTest {

    @Test
    public void testCreateProduct(ITestContext context){
        Response response = given()
                .spec(requestSpecification)
                .body(requestPayloads.setProductPayload())
                .when()
                .post(APIConstants.getOrCreateProducts);

        assertActions.verifyStatusCode(response);
       assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "title"), "Pikachu pijama", "The title isn't right.");
       assertActions.verifyResponseBody(apiActions.getDataFromJsonPath(response, "price"), 500, "The price isn't right.");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "description"), "Pijamas Unisex Adult Cosplay Pikachu", "The description isn't right.");
     //  assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "image"), "https://www.dhresource.com/albu_844327653_00/temp2.0x0.jpg", "The image isn't there.");

        int id = apiActions.getDataFromJsonPath(response, "id");
        context.getSuite().setAttribute("id", id);
        System.out.println("Product ID is: " + id);
    }

}
