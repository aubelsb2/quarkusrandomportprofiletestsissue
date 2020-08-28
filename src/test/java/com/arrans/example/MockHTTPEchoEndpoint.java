package com.arrans.example;

import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

// This is where it is, you can nest these calls too -- look at documentation
// This is an end point which returns a section of the request in JSON so we can inspect it.
@Path("echo")
public class MockHTTPEchoEndpoint {
    protected org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    // Get just returns the headers
    @GET
    @Produces("application/json")
    public String getEcho(
    ) {
        log.info("Got message");
        return "";
    }

    // Returns the body and the header
    @POST
    @Produces("application/json")
    public String postEcho(
            String body
    ) {
        log.info("Got message");
        return body;
    }

}
