package io.github.mayumisiano.quarkussocial.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogConfig {
    public static <T> Logger getLogger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}