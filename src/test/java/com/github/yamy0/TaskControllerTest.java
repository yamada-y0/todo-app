package com.github.yamy0;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class TaskControllerTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().get("/task")
                .then()
                .statusCode(200);
    }

}