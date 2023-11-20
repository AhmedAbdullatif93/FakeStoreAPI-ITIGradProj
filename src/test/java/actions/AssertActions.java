package actions;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void verifyStatusCode(Response response) {
        assertTrue(String.valueOf(response.getStatusCode()).startsWith("20"), "value of status code is" + response.getStatusCode());
    }
    public void verifyInvalidStatusCode(Response response) {
        assertTrue(String.valueOf(response.getStatusCode()).startsWith("40"), "value of status code is" + response.getStatusCode());
    }

    public void verifyResponseTime(Response response){
        long responseTime = response.getTime();
        assertTrue(responseTime < 1000, "Response time is not less than 1000ms. Actual response time: " + responseTime + "ms");
    }
    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(float actual, float expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseContainsAtLeast20Products(Response response) {
        // Convert the JSON array string to an array and check its size
        String[] products = response.jsonPath().getString("id").split(",");
        assertEquals(products.length, 20, "Expected at least 20 products in the response");
    }

    public void validatePriceFieldIsNonNegative(Response response) {
        // Extract prices from the JSON response and validate each one
        List<Object> prices = response.jsonPath().getList("price");

        for (Object price : prices) {
           assertTrue(price instanceof Number, "Price should be a number");

            // Handle the conversion appropriately based on the actual type
            double priceValue;
            if (price instanceof Double) {
                priceValue = (Double) price;
            } else if (price instanceof Float) {
                priceValue = (Float) price;
            }
            else if (price instanceof Integer) {
                priceValue = (Integer) price;
            }else {
                throw new AssertionError("Unsupported numeric type for price: " + price.getClass());
            }

            assertTrue(priceValue >= 0, "Price should be non-negative");
        }
    }


    public void verifyResponseBody(double actual, double expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(boolean actual, boolean expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(ArrayList actual, String expected, String description){
        assertTrue(actual.contains(expected), description);
    }

    public void verifyResponseTrue(Response response, String description){
        assertTrue(response.asString().contains("true"), description);
    }


    public void verifyResponseBody(Boolean isAvailable, String description) {
        assertFalse(isAvailable, description);
    }

    public void verifyResponseContentType(Response response, String expectedType) {
        assertEquals(response.getContentType(), expectedType, "Response content type is not " + expectedType);
    }

    public void verifyResponseBodyValueNotNull(String actual) {
        assertNotNull(actual, actual + " is null");
    }


    public void verifyResponseBodyNotEqual(String actual_access_token, String last_access_token, String description) {
        assertNotEquals(actual_access_token, last_access_token, description);
    }

    public void verifyResponseBodyElementContentString(String actual, String expected, String description){
        assertTrue(actual.contains(expected), description);
    }

    public void verifySizeList(int actualAmount, int expectAmount, String description) {
        assertEquals(actualAmount, expectAmount, description);
    }
}
