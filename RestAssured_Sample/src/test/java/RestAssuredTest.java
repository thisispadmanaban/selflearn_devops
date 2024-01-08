
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RestAssuredTest {

    RequestSpecification requestSpec;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeAll
    public static void setupTest() {
        System.out.println("Setting up the test");
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void verifyStatus() {
        requestSpec = RestAssured.given();
        //response = requestSpec.get();
        response = requestSpec.request(Method.GET,"api/users?page=2");
        String responseBody = response.prettyPrint();
        System.out.println("Response Body: " + responseBody);
        System.out.println("Response Status: " + response.statusLine());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }
}

