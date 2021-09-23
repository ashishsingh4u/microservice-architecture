package com.techienotes.cloudconfigserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest({"server.port:0", "eureka.client.enabled:false"})
class CloudConfigServerApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

}
