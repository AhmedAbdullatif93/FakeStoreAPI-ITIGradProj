package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.dataobjects.UserDetails;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class updateUser extends BaseTest{

    @Test
    public void testUpdateUser(ITestContext context){
        UserDetails userDetails = requestPayloads.setToUpdateUserPayload();
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .body(userDetails)
                .when()
                .put(APIConstants.updateOrDeleteUser);

        String email = apiActions.getDataFromJsonPath(response, "email");

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "username"), userDetails.getUsername(), "Name didn't update");
        assertActions.verifyResponseBody(email, userDetails.getEmail(), "Email didn't update");

        context.getSuite().setAttribute("email", email);

        System.out.println(response.body().prettyPeek());
    }
}
