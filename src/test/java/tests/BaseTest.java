package tests;

import actions.APIActions;
import actions.AssertActions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.AhmedAbdullatif.endpoints.APIConstants;
import org.AhmedAbdullatif.payload.RequestPayloads;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected RequestSpecification requestSpecification;
    protected AssertActions assertActions = new AssertActions();
    protected APIActions apiActions = new APIActions();
    protected RequestPayloads requestPayloads = new RequestPayloads();

    @BeforeMethod
    protected void setUpConfiguration(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.baseUrl)
                .setAccept("application/json")
                .setContentType("application/json")
                .build()
                .log().all();
    }
}
