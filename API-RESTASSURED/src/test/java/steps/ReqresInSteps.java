package steps;

import apiHelper.RestAssuredAssertions;
import apiHelper.RestAssuredHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class ReqresInSteps {

    @Given("I perform GET operation with content type JSON")
    public void iPerformGETOperationFor() {
        given().contentType(ContentType.JSON);
    }

    @And("I search for the specific user {string}")
    public void iSearchForUserWithId(String userResource) {
        when().get(String.format("https://reqres.in/%s",userResource)).
                then().statusCode(200)
                .body("data.first_name",is("Janet"));

    }

    @Given("User sets the link and contentType for request")
    public void setupRequestSpecification() {
        RestAssuredHelper.setupRequestSpecification("https://reqres.in", "json");
    }
    @When("User sends the request to the api")
    public void performGetAction() {
        RestAssuredHelper.getRequest("/api/users/2");
    }
    @Then("Status Code is 200")
    public void checkIfStatusCodeIs200() {
        RestAssuredAssertions.checkIfStatusCodeIs200();
    }




    @Then("I should get the response with code {int}")
    public void iShouldGetTheResponseWithCode(int statusCode) {
    }
}
