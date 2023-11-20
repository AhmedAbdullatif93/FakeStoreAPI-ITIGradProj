package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProduct extends BaseTest {
    @Test
    public void testGetProduct(ITestContext context){
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get(APIConstants.getProduct);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseContainsAtLeast20Products(response);
        assertActions.validatePriceFieldIsNonNegative(response);
        System.out.println(response.body().prettyPeek());
    }
}
