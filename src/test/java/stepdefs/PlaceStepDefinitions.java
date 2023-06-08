package stepdefs;

import endpoint.PlaceHolderEndpoint;
import helper.GeneratedRandom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import model.PlaceHolder;

public class PlaceStepDefinitions {

    BaseStep baseStep;
    PlaceHolderEndpoint placeHolderEndpoint = new PlaceHolderEndpoint();

    public PlaceStepDefinitions(BaseStep baseStep) {
        this.baseStep = baseStep;
    }

    @When("request get api placeholder")
    public void requestGetApiAndValidateJsonSchema() {
        baseStep.setResponse(placeHolderEndpoint.getPlace(baseStep.getRequest()));
    }

    @And("validation json schema type data response")
    public void validationJsonSchemaTypeDataResponse() {
        placeHolderEndpoint.verifyResponseJsonSchema(baseStep.getResponse());
    }

    @When("send request post api placeholder has a title value {string} body value {string} and userId {int}")
    public void requestPostApiPlaceholder(String title, String body, int userId) {
        baseStep.setResponse(placeHolderEndpoint.postPlace(baseStep.getRequest(), new PlaceHolder(title, body, userId)));
    }

    @When("send request post api placeholder has a title,body and userId value")
    public void sendRequestPostApiPlaceholderHasATitleBodyAndUserIdValue() {
        baseStep.setResponse(placeHolderEndpoint.postPlace(baseStep.getRequest(), new PlaceHolder(
                GeneratedRandom.generatedTitle(),
                GeneratedRandom.generatedBody(),
                GeneratedRandom.generatedId()
        )));
    }
}
