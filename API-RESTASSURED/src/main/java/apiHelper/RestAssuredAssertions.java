package apiHelper;

import io.restassured.response.Response;

import static apiHelper.ScenarioContext.ContextType.HTTP_RESPONSE;
import static apiHelper.ScenarioContext.getContext;

public class RestAssuredAssertions {

    public static void checkIfStatusCodeIs200() {
        Response response = getContext(HTTP_RESPONSE);

        response.then().statusCode(200);
    }
}
