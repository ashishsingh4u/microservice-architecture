package com.techienotes.cloud.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest({"server.port:0", "eureka.client.enabled:false"})
class CloudGatewayApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

}
