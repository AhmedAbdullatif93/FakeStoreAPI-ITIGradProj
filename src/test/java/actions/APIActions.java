package actions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import javax.swing.text.html.HTML;

public class APIActions {
    public <T> T getDataFromJsonPath(Response response, String jsonPath) {
        JsonPath jpath = response.jsonPath();
        return jpath.get(jsonPath);
    }

    public String getDataFromHTMLBody(Response response){
        return response.getBody().asString();
    }
}
