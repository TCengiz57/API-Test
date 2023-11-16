package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiExampleBaseUrl {

    protected RequestSpecification specDummyRestApiExample;


    @Before
    public void setUp() {

        specDummyRestApiExample = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/").build();
    }
}