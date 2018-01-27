package com.slf4j.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tslf4j {

    @Test
    public void t1() {
        Logger logger = LoggerFactory.getLogger(Tslf4j.class);
        logger.info("hello world {}-{}",1,2);

    }
}
