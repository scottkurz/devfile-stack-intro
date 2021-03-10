/*******************************************************************************
Copyright (c) 2020, 2021 IBM Corporation and others

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/
package dev.odo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndpointIT {

    Logger logger = LoggerFactory.getLogger(EndpointIT.class);
    private String expectedGreeting = "Hello! Welcome to Open Liberty";

    private static Client client;

    @BeforeAll
    public static void init() {
        client = ClientBuilder.newClient();
    }

    @AfterAll
    public static void destroy() throws Exception {
        client.close();
    }

    public WebTarget getTarget(String path) {
        String port = System.getProperty("http.port");
        String context = System.getProperty("app.path");
        String url = "http://localhost:" + port + "/" + context + "/";
        return client.target(url + path);
    }

    @Test
    public void testAppResponse() {
        logger.info("In test method: testAppResponse");

        WebTarget target = getTarget("resource");
        Response getResponse = target.request().get();
        try {
            assertEquals(200, getResponse.getStatus(), "Request received an invalid status response. Details: " + getResponse.getStatusInfo().getReasonPhrase());
            String msg = getResponse.readEntity(String.class);
            assertEquals(expectedGreeting, msg);
        } finally {
            getResponse.close();
        }
    }

}
