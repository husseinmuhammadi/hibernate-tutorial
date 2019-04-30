package com.javastudio.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Startup {
    static Logger logger = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        logger.info("Start ...");

        logger.info("End ...");
    }
}
