package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class filterProductsByCategoryName extends BaseTest{

    @Test
    public void testGetFilterByCategory(ITestContext context){
        String categoryName = "electronics";
        Response response = given()
                .spec(requestSpecification)
                .pathParam("category", categoryName)
                .when()
                .get(APIConstants.getProductByCategory);

        int count = response.path("data.size()");
        System.out.println("ID Count: "+count);

        assertActions.verifyStatusCode(response);
        for (int i = 1; i < count; i++) {
            assertActions.verifyResponseBodyElementContentString(apiActions.getDataFromJsonPath(response, "["+i+"].category"), "electronics", "Object "+i+" category isn't electronics");
        }

        System.out.println(response.body().prettyPeek());
    }


}
