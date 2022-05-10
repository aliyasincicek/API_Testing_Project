package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.RegresInPojo;

import static io.restassured.RestAssured.given;
import static stepdefinitions.Hooks.spec;

public class PostMethodStepDef3 {
    Response response;
    RegresInPojo expectedData;


    @Given("user sets the path params for post method")
    public void user_sets_the_path_params_for_post_method() {
        spec.pathParams("parameter1","api","parameter2","users");
    }
    @Given("user makes a post request")
    public void user_makes_a_post_request() {
        expectedData= new RegresInPojo("morpheus","leader");
        System.out.println("expectedData = " + expectedData);
        response=given().contentType(ContentType.JSON).spec(spec).
                body(expectedData).when().post("/{parameter1}/{parameter2}");
        response.prettyPrint();



    }
    @Then("verify status code")
    public void verifyStatusCode() {
        response.then().assertThat().statusCode(201);


    }
    @Then("user validates the changes")
    public void user_validates_the_changes() {

        RegresInPojo actualData=response.as(RegresInPojo.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(expectedData.getName(),actualData.getName());
        Assert.assertEquals(expectedData.getJob(),actualData.getJob());

    }


}
