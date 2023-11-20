package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteProduct extends BaseTest{
    @Test
    public void testDeleteProduct(ITestContext context){
       // int id = (int) context.getSuite().getAttribute("id");
        /*The user will not be deleted on the database.
          but if you sent data successfully it will return you the fake deleted user. (on fakestoreAPI DOCs)*/

        int id = 7;
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .when()
                .delete(APIConstants.deleteProduct);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseTime(response);
        System.out.println(response.body().prettyPeek());

    }

}
