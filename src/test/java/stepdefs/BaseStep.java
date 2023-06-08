package stepdefs;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class BaseStep {
    private Response response;
    private RequestSpecification request;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return (Response) this.response;
    }

    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    public RequestSpecification getRequest() {
        return this.request;
    }
}
