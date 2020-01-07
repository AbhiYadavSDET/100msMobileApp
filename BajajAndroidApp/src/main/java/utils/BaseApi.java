package utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {
    private boolean httpsRequest;
    private String baseUri;
    private String port;
    private String basePath;
    private BaseApi.HTTP_METHOD httpMethod;
    private RequestSpecBuilder specBuilder;

    public BaseApi() {
        this.httpsRequest = Configuration.APIDefaults.IS_HTTPS_REQUIRED;
        this.baseUri = Configuration.APIDefaults.HOST;
        this.port = Configuration.APIDefaults.PORT;
        this.specBuilder = new RequestSpecBuilder();
    }

    public void setHttpsRequest(boolean httpsRequest) {
        this.httpsRequest = httpsRequest;
    }

    protected void setHttpMethod(BaseApi.HTTP_METHOD method) {
        this.httpMethod = method;
    }

    public BaseApi.HTTP_METHOD getHttpMethod() {
        return this.httpMethod;
    }

    public RequestSpecBuilder getSpecBuilder() {
        return this.specBuilder;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBasePath() {
        return this.basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Response execute() {
        RequestSpecification specification = this.specBuilder.build();
        switch (this.httpMethod) {
            case POST:
                return (Response) RestAssured.given().spec(specification).when().post();
            case GET:
                return (Response) RestAssured.given().spec(specification).when().get();
            case PUT:
                return (Response) RestAssured.given().spec(specification).when().put();
            case DELETE:
                return (Response) RestAssured.given().spec(specification).when().delete();
            case PATCH:
                return (Response) RestAssured.given().spec(specification).when().patch();
            default:
                return null;
        }
    }

    public String getBaseUri() {
        String completeUri;
        if (this.httpsRequest) {
            completeUri = "https://".concat(this.baseUri);
        } else {
            completeUri = "http://".concat(this.baseUri);
        }

        if (!(this.port.equals((Object) null) | this.port.equalsIgnoreCase("null"))) {
            completeUri = completeUri.concat(":").concat(this.port);
        }

        return completeUri;
    }

    public String getBaseUri(Boolean isHttpsRequired, String host, String port) {
        String completeUri;
        if (isHttpsRequired) {
            completeUri = "https://".concat(host);
        } else {
            completeUri = "http://".concat(host);
        }

        return !(port.equals((Object) null) | port.equalsIgnoreCase("null")) ? completeUri.concat(":").concat(port) : completeUri;
    }

    public static enum HTTP_METHOD {
        POST,
        GET,
        PUT,
        DELETE,
        PATCH;

        private HTTP_METHOD() {
        }
    }
}

