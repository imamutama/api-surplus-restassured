package endpoint;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PlaceHolder;

public class PlaceHolderEndpoint extends BaseEndpoints {
    private final String PLACE_ENDPOINT_PATH = "/posts";

    public String getUrlPath() {
        return getBaseUrl() + this.PLACE_ENDPOINT_PATH;
    }

    public Response getPlace(RequestSpecification request) {
        return sendRequest(request, Method.GET_REQUEST, getUrlPath(), null);
    }

    public Response postPlace(RequestSpecification request, PlaceHolder placeHolder) {
        return sendRequest(request, Method.POST_REQUEST, getUrlPath(), placeHolder);
    }


}
