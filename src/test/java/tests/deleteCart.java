package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteCart extends BaseTest{

    @Test
    public void testDeleteCart(ITestContext context){
        int id = 7;
        Response response = given()
                .spec(requestSpecification)
                .pathParams("cart", id)
                .when()
                .delete(APIConstants.deleteCart);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
