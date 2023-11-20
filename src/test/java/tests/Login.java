package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Login extends BaseTest{
    @Test
    public void testAuthentication(ITestContext context){
        JSONObject data = new JSONObject();
        data.put("username", "mor_2314");
        data.put("password", "83r5^_");

        Response response = given()
                .spec(requestSpecification)
                .body(data.toString())
                .when()
                .post(APIConstants.loginAuth);

        assertActions.verifyStatusCode(response);
        int bodySize = response.getBody().asString().length();
        assertActions.verifySizeList(bodySize,152,"Body size isn't 152B");
        String token = apiActions.getDataFromJsonPath(response, "token");
       // assertActions.verifyResponseBodyValueNotNull(token);
        String expectedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjIsInVzZXIiOiJtb3JfMjMxNCIsImlhdCI6MTcwMDI2NDcxNH0.ppNotwWMjiiYy4RnD6su4HKk4ODlwnZtCKhYSaP0jCg";
        assertActions.verifyResponseBody(token.contains(expectedToken),"Actual token isn't equal to the expected");

        //System.out.println("this is the token --> "+token+" <-----");
        System.out.println(response.body().prettyPeek());

    }

}
