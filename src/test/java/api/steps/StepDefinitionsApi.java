package api.steps;

import api.data.API;
import api.utils.PropReader;

import java.util.*;
import java.util.concurrent.TimeUnit;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class StepDefinitionsApi {
    private String accessToken, apiBaseUrl;
    private static RequestSpecification requestSpecification;
    private Properties properties;
    private Response response;

    public StepDefinitionsApi() throws Exception {
        properties = new PropReader().getPropValues();
        apiBaseUrl = properties.getProperty("apiBaseUrl");
    }

    @Given("client get authorization using oauth2")
    public void clientAccessToken() {
        accessToken = properties.getProperty("accessToken");
        requestSpecification = RestAssured.given()
                .baseUri(apiBaseUrl)
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken);
    }

    @When("client create activities with method POST")
    public void createActivities(DataTable dataTable) {
        Map<String, Object> data = dataTable.asMap(String.class, String.class);
        Map<String, Object> payload = new HashMap<>();
        Random rand = new Random();
        API.setIdActivities(rand.nextInt(1000));
        payload.put("id", API.getIdActivities());
        payload.put("completed", true);
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            payload.put(entry.getKey() , data.get(entry.getKey()));
        }
        response = requestSpecification.body(payload).post("/api/v1/Activities");
        response.headers();
        response.prettyPeek();
        response.prettyPrint();
    }

    @When("client get activities with method GET with id")
    public void getActivities() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        response = requestSpecification
                .get(String.format("/api/v1/Activities/", API.getIdActivities()));
        response.headers();
        response.prettyPeek();
        response.prettyPrint();
    }

    @When("client update activities with method PUT with id")
    public void updateActivities() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "update title");
        response = requestSpecification
                .body(payload)
                .put(String.format("/api/v1/Activities/%s", API.getIdActivities()));
        response.headers();
        response.prettyPeek();
        response.prettyPrint();
    }

    @When("client delete activities with method DELETE with id")
    public void deleteActivities() {
        response = requestSpecification
                .delete(String.format("/api/v1/Activities/%s", API.getIdActivities()));
        response.headers();
        response.prettyPeek();
        response.prettyPrint();
    }

    @When("client send {string} request {string}")
    public void requestApi(String method, String endpoint) {
        switch (method.toLowerCase()) {
            case "get":
                response = requestSpecification.get(endpoint);
                break;
            case "post":
                response = requestSpecification.post(endpoint);
                break;
            case "put":
                response = requestSpecification.put(endpoint);
                break;
            case "delete":
                response = requestSpecification.delete(endpoint);
                break;
            case "patch":
                response = requestSpecification.patch(endpoint);
                break;
            default:
        }
        response.headers();
        response.prettyPeek();
        response.prettyPrint();
    }

    @When("client send {string} request {string} with body:")
    public void requestApiWithBody(String method, String endpoint, String object) {
        switch (method.toLowerCase()) {
            case "get":
                response = requestSpecification.body(object).get(endpoint);
                break;
            case "post":
                response = requestSpecification.body(object).post(endpoint);
                break;
            case "put":
                response = requestSpecification.body(object).put(endpoint);
                break;
            case "delete":
                response = requestSpecification.body(object).delete(endpoint);
                break;
            case "patch":
                response = requestSpecification.body(object).patch(endpoint);
                break;
            default:
        }
        response.headers();
        response.prettyPeek();
        response.prettyPrint();
    }

    @Then("client should see response with status code {string}")
    public void responseShouldBe(String statusCode) {
        Assert.assertEquals(statusCode, String.valueOf(response.statusCode()));
    }
}
