package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getCarts extends BaseTest {
    @Test
    public void testGetCarts(ITestContext context){
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get(APIConstants.getOrAddCarts);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
