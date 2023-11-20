package tests;

import io.restassured.response.Response;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class filterCartsBySpecificDate extends BaseTest{

    @Test
    public void testGetFilterByDate(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("startdate", "2020-03-01")
                .queryParam("enddate", "2020-10-10")
                .when()
                .get(APIConstants.getOrAddCarts);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }

}
