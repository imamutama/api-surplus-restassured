package stepdefs;

import endpoint.BaseEndpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalStepDefinition {

    BaseStep baseStep;
    BaseEndpoints endpoints = new BaseEndpoints();

    public GlobalStepDefinition(BaseStep baseStep) {
        this.baseStep = baseStep;
    }

    @Given("set header application json")
    public void setHeaderApplicationJson() {
        baseStep.setRequest(endpoints.getRequestWithJSONHeaders());
    }

    @Then("request response has a {int} response code")
    public void requestResponseHasAResponseCode(int statusCode) {
        endpoints.verifyResponseStatusValue(baseStep.getResponse(), statusCode);
    }

    @When("set parameter with param {string} has value a {int} in request specification")
    public void setParameterWithParamHasValueAInRequest(String key, int value) {
        baseStep.setRequest(endpoints.requestParam(key, value));
    }

    @When("set parameter with param {string} has value a {string} in request specification")
    public void setParameterWithParamHasValueAInRequest(String key, String value) {
        baseStep.setRequest(endpoints.requestParam(key, value));
    }

    @And("requests response contains the correct json data with key {string} and value {int}")
    public void requestsResponseContainsTheCorrectJsonData(String key, int value) {
        endpoints.verifyResponseKeyValuesInt(key, value, baseStep.getResponse());
    }

    @And("requests response contains the correct json data with key {string} and value {string}")
    public void requestsResponseContainsTheCorrectJsonData(String key, String value) {
        endpoints.verifyResponseKeyValuesString(key, value, baseStep.getResponse());
    }




}
