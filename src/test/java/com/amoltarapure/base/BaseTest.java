package com.amoltarapure.base;

import com.amoltarapure.asserts.AssertActions;
import com.amoltarapure.endpoints.APIConstants;
import com.amoltarapure.modules.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest
{
    // This is called as common to all test cases.
    // CommonToAll Testcase
    // Base URL, Content Type - json - common

    public RequestSpecification requestSpecification;
    public Response response;

    public ValidatableResponse validatableResponse;

    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;

    @BeforeTest
    public void setup() {

        System.out.println("Starting of the Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BASE_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();


    }

    @AfterTest
    public void tearDown() {
        System.out.println("Finished the Test!");
    }

}
