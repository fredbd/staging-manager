package com.oppscience.ingestion;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class FileResourceTest {


    @Test
    public void testList() {
        given()
          .when().get("/dataflow/dataflowId/staging/file/list")
          .then()
          .statusCode(200)
          .body(is("Hello RESTEasy"));
    }

}