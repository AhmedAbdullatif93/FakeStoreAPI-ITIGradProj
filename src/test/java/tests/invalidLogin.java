package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class invalidLogin extends BaseTest {

    @Test
    public void testInvalidAuthentication(ITestContext context){
        JSONObject data = new JSONObject();
        data.put("username", "mor_231");
        data.put("password", "83r5^_");

        Response response = given()
                .spec(requestSpecification)
                .body(data.toString())
                .when()
                .post(APIConstants.loginAuth);

        assertActions.verifyInvalidStatusCode(response);
        int bodySize = response.getBody().asString().length();
        assertActions.verifySizeList(bodySize,33,"Body size isn't 33B");
        String reply = apiActions.getDataFromHTMLBody(response);
        System.out.println("Reply: "+reply);
        assertActions.verifyResponseBody(reply,"username or password is incorrect", "Reply is wrong");
        System.out.println(response.body().prettyPeek());

    }

}
