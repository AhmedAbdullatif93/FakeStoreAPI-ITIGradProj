package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteUser extends BaseTest{
    @Test
    public void testDeleteUser(ITestContext context){
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .when()
                .delete(APIConstants.updateOrDeleteUser);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }

}
