package endpoint;

import helper.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaseEndpoints {
    public static final int SUCCESS_STATUS_CODE = 200;

    ConfigFileReader configFileReader = new ConfigFileReader();

    public BaseEndpoints() {
    }

    public String getBaseUrl() {
        return configFileReader.getBaseUrl();
    }

    public RequestSpecification getRequestWithJSONHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", "application/json");
        return r;
    }

    public RequestSpecification requestParam(String key, int value) {
        RequestSpecification request = RestAssured.given().queryParam(key, value);
        return request;
    }

    public RequestSpecification requestParam(String key, String value) {
        RequestSpecification request = RestAssured.given().queryParam(key, value);
        return request;
    }

    protected JSONObject createJSONPayload(Object pojo) {
        return new JSONObject(pojo);
    }

    public Response sendRequest(RequestSpecification request, Method method, String url, Object pojo) {
        Response response = null;
        if (null != pojo) {
            String payload = createJSONPayload(pojo).toString();
            request.body(payload).log().body();
        }
        switch (method) {
            case GET_REQUEST:
                if (null == request) {
                    response = RestAssured.when()
                            .get(url);
                } else {
                    response = request.get(url);
                }
                break;
            case POST_REQUEST:
                if (null == request) {
                    response = RestAssured.when().post(url);
                } else {
                    response = request.post(url);
                }
                break;
            default:
                if (null == request) {
                    response = RestAssured.when().post(url);
                } else {
                    response = request.post(url);
                }
                response = request.post(url);
                break;
        }
        return response;
    }

    public void verifyResponseStatusValue(Response response, int expectedCode) {
        assertThat(response.getStatusCode(), is(expectedCode));
        response.then().log().body();
    }

    public void verifyResponseJsonSchema(Response response) {
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "/src/test/resources/schema/jsonSchema.json")))
                .extract().response();
    }

    public void verifyResponseKeyValuesString(String key, String val, Response r) {
        String keyValue = r.jsonPath().getString(key);
        assertThat(keyValue, is(val));
    }

    public void verifyResponseKeyValuesInt(String key, int val, Response r) {
        int keyValue = r.jsonPath().getInt(key);
        assertThat(keyValue, is(val));
    }

    public void verifyResponseKeyValuesBoolean(String key, boolean val, Response r) {
        boolean keyValue = r.jsonPath().getBoolean(key);
        assertThat(keyValue, is(val));
    }

    public void verifyTrue(boolean val) {
        assertTrue(val);
    }

    public void verifyFalse(boolean val) {
        assertFalse(val);
    }


    public enum Method {
        GET_REQUEST,
        POST_REQUEST,

    }
}
