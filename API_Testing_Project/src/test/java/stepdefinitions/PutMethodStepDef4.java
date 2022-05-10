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

public class PutMethodStepDef4 {

    Response response;
    RegresInTestData testObject=new RegresInTestData();
    JSONObject expectedRequest=testObject.setUpPutData();


    @Given("user sets the path params for put method")
    public void userSetsThePathParamsForPutMethod() {
        spec.pathParams("parameter1","api","parameter2","users","parameter3","2");

    }

    @Given("user makes a put request")
    public void userMakesAPutRequest() {


        System.out.println("expectedData = " + expectedRequest);
        response=given().contentType(ContentType.JSON).spec(spec).
                body(expectedRequest.toString()).when().put("/{parameter1}/{parameter2}/{parameter3}");
        response.prettyPrint();
    }

    @Then("verify Status code")
    public void verifyStatusCode() {
        response.then().assertThat().statusCode(200);
    }

    @And("user validates the Changes")
    public void userValidatesTheChanges() {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedRequest.get("name"),jsonPath.getString("name"));
        Assert.assertEquals(expectedRequest.get("job"),jsonPath.getString("job"));

    }
}
