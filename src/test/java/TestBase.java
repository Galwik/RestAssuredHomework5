import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class TestBase {

    @BeforeEach
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public RequestSpecification getRequestSpecification() {
        return given()
                .baseUri("https://samples.openweathermap.org")
                .basePath("/data/2.5/weather")
                .header("name","Kamil")
                .header("age", "50")
                .param("q", "London, uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();
    }

    public ResponseSpecification getResponseSpecification() {
        ResponseSpecification responseSpecification = RestAssured.expect();

        return responseSpecification
                .log()
                .all()
                .time(Matchers.lessThan(3000L))
                .contentType(ContentType.JSON)
                .statusCode(200);
    }
}