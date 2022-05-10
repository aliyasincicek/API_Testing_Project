package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;


import static io.restassured.RestAssured.given;
import static stepdefinitions.Hooks.spec;


public class GetMethodStepDef1 {
    Response response;

    @Given("user sets the necessary path params")
    public void user_sets_the_necessary_path_params() {

       spec.pathParams("parameter1","api","parameter2","users");

    }
    @Given("user sends the get request")
    public void user_sends_the_get_request() {
        response=given().spec(spec).when().get("/{parameter1}/{parameter2}");
        //response.prettyPrint();

    }

    @Then("status code should be {int} for rooms")
    public void status_code_should_be_for_rooms(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");
    }

    @Then("verify that the response body should be as an expected")
    public void verify_that_the_response_body_should_be_as_an_expected() {

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals("charles.morris@reqres.in",jsonPath.getString("data[4].email"));
        Assert.assertEquals("Charles",jsonPath.getString("data[4].first_name"));
        Assert.assertEquals("Morris",jsonPath.getString("data[4].last_name"));
    }
}
