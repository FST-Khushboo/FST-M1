package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2
{
    String baseURI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void PostMethod() throws IOException {
        FileInputStream inputJason = new FileInputStream("src/test/java/activities/userInformation.json");
        String reqBody = new String(inputJason.readAllBytes());
        Response response = given().contentType(ContentType.JSON)
                .body(reqBody).when().post(baseURI);
        inputJason.close();
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        //assertions
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("103"));

    }

    @Test(priority = 2)
    public void getMethod() throws IOException {
        File outputJason = new File("src/test/java/Activities/userGetResponse.json");
        Response response = given().contentType(ContentType.JSON)
                .when().pathParam("username", "justinBieber")
                .get(baseURI + "/{username}");

        //print response
        String resBody  = response.getBody().asPrettyString();
        outputJason.createNewFile();
        FileWriter writer = new FileWriter(outputJason.getPath());
        writer.write(resBody );
        writer.close();
        response.then().body("id", equalTo(103));
        response.then().body("username", equalTo("justinBieber"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));

    }

    @Test
    public void deleteMethod() {
        Response response = given().contentType(ContentType.JSON)
                .when().pathParam("username", "justinBieber")
                .delete(baseURI + "/{username}");
        //Assertion
        response.then().body("code",equalTo(200));
        response.then().body("message", equalTo("justinBieber"));
    }
}

