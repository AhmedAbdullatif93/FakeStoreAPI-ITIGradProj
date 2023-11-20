package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUser extends BaseTest{
    @Test
    public void testGetUser(ITestContext context){
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", 1)
                .when()
                .get(APIConstants.getUser);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());

        int id = apiActions.getDataFromJsonPath(response, "id");
        context.getSuite().setAttribute("id", id);
        System.out.println(id);
    }

}
