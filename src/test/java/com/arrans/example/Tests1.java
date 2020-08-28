package com.arrans.example;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static io.restassured.RestAssured.when;

@QuarkusTest
@TestProfile(Tests1.TestProfile.class)
public class Tests1 {

    @TestHTTPEndpoint(MockHTTPEchoEndpoint.class)
    @TestHTTPResource
    URL mockHttpEndPoint;

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testAMessageEndToEnd() throws InterruptedException {

        log.info("Mock URL: {}", mockHttpEndPoint);

        when().
                get(mockHttpEndPoint.toString()).
                then().
                statusCode(200);

    }


    public static class TestProfile implements QuarkusTestProfile {
    }
}
