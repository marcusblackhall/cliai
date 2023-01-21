package com.ilovecoding.aicli.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AiPropertiesTest {

    @Test
    void aiUrl() {

        String url = AiProperties.aiUrl();
        assertNotNull(url);
    }
}