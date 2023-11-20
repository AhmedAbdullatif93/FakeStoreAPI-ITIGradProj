package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetId extends BaseTest {

    @Test
    public void getID(ITestContext context) {
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get(APIConstants.getProduct+"/7");
        System.out.println(response.body().prettyPeek());

        int id = apiActions.getDataFromJsonPath(response, "id");
        System.out.println("Product ID is: " + id);

    }
}
