package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import testData.RegresInTestData;

import static io.restassured.RestAssured.given;
import static stepdefinitions.Hooks.spec;

public class PatchMethodStepDef5 {
    Response response;
    RegresInTestData testObject=new RegresInTestData();
    JSONObject expectedRequest=testObject.setUpPatchRequest();

    @Given("user sets the path params for patch method")
    public void userSetsThePathParamsForPatchMethod() {
        spec.pathParams("parameter1","api","parameter2","users","parameter3","2");
    }

    @Given("user makes a patch request")
    public void userMakesAPatchRequest() {
        System.out.println("expectedData = " + expectedRequest);
        response=given().contentType(ContentType.JSON).spec(spec).
                body(expectedRequest.toString()).when().patch("/{parameter1}/{parameter2}/{parameter3}");
        response.prettyPrint();
    }
    @Then("verify Status Code")
    public void verifyStatusCode() {
        response.then().assertThat().statusCode(200);
    }
    @And("user Validates the Changes")
    public void userValidatesTheChanges() {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedRequest.get("name"),jsonPath.getString("name"));
        Assert.assertEquals(expectedRequest.get("job"),jsonPath.getString("job"));
    }
}
