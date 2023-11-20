package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProductsByCategoryName extends BaseTest{

    @Test
    public void testGetFilterByCategory(ITestContext context){
        String categoryName = "electronics";
        Response response = given()
                .spec(requestSpecification)
                .pathParam("category", categoryName)
                .when()
                .get(APIConstants.getProductByCategory);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBodyElementContentString(apiActions.getDataFromJsonPath(response, "[0].category"), "electronics", "Title don't content category electronics");
        System.out.println(response.body().prettyPeek());
    }


}
