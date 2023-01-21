package com.ilovecoding.aicli.config;

import java.io.IOException;
import java.util.Properties;

public class AiProperties {

    private final static Properties aiProperties = new Properties();

    static {
        try {
            aiProperties.load(
                    AiProperties.class.getClassLoader()
                            .getResourceAsStream("askai.properties")
            );
        } catch (IOException e) {
            throw new RuntimeException("property file is missing", e);
        }

    }

    public static String aiUrl() {
        return aiProperties.getProperty("openai.url");
    }
}
