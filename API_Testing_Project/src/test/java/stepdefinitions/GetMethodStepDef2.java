package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static stepdefinitions.Hooks.spec;

public class GetMethodStepDef2 {
    Response response;

    @Given("user sets the path params")
    public void userSetsThePathParams() {
        spec.pathParams("parameter1","api","parameter2","users", "parameter3","1");

    }

    @Given("user sends the get single request")
    public void userSendsTheGetSingleRequest() {
        response=given().spec(spec).when().get("/{parameter1}/{parameter2}/{parameter3}");
        response.prettyPrint();
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        response.then().assertThat().statusCode(statusCode)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");
    }

    @Then("verify that the Response body should be as an expected")
    public void verifyThatTheResponseBodyShouldBeAsAnExpected() {
        response.then().assertThat().body("data.first_name", Matchers.equalTo("George"),
                "data.last_name", Matchers.equalTo("Bluth"),
                "data.email",Matchers.equalTo("george.bluth@reqres.in"));

    }
}
