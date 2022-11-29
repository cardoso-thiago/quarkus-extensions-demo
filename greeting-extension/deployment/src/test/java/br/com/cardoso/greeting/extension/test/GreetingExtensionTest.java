package br.com.cardoso.greeting.extension.test;

import io.restassured.RestAssured;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusUnitTest;

import static org.hamcrest.Matchers.containsString;

public class GreetingExtensionTest {

    @RegisterExtension
    static final QuarkusUnitTest config = new QuarkusUnitTest()
            .withEmptyApplication();

    @Test
    public void testGreeting() {
        RestAssured.when().get("/greeting").then().statusCode(200).body(containsString("Hello"));
    }
}
