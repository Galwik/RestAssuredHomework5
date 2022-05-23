import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class WeatherResponseTest extends TestBase{

    @Test
    public void shouldCheckWeatherResponse() {
        given(getRequestSpecification())
                .when()
                .get()
                .then()
                .spec(getResponseSpecification())
                .body("main.pressure", is(1012))
                .body("wind.speed", is(4.1F))
                .body("sys.country", is("GB"));
    }
}