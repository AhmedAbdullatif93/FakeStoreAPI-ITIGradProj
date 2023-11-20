package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.dataobjects.UserDetails;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUser extends BaseTest{

    @Test
    public void testCreateUser(ITestContext context){
        UserDetails userDetails = requestPayloads.setUserPayload();
        Response response = given()
                .spec(requestSpecification)
                .body(userDetails)
                .when()
                .post(APIConstants.getOrCreateUsers);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((Integer) apiActions.getDataFromJsonPath(response, "id"),11,"User ID is not 11");

        System.out.println(response.body().prettyPeek());
    }

}
