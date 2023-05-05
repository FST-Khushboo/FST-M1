package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Activity3 {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();


        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        Object[][] testData = new Object[][]{
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }

        };
    return testData;
        }
    @Test(priority=1)
    // Test case using a DataProvider
    public void addPets() {
        String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
        response = given().spec(requestSpecification) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post();
        reqBody = "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";

        response = given().spec(requestSpecification) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request
        // Assertions
        response.then().spec(responseSpecification); // Use responseSpec

    }
    @Test(dataProvider = "petInfoProvider", priority=2)
    public void getPets(int id, String name, String status) {

        Response response = given().spec(requestSpecification) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().get("/{petId}"); // Send GET request
        System.out.println(response.asPrettyString());
        response.then().spec(responseSpecification) // Use responseSpec
                .body("name", equalTo(name))
                .body("status", equalTo(status));

    }
    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec(requestSpecification)
                .pathParam("petId",id)
                        .when().delete("/{petId}");
        response.then()
                .body("code", equalTo(200));


    }


}

