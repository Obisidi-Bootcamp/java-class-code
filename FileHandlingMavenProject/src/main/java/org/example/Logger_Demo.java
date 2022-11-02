package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logger_Demo {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Logger_Demo.class);
        Integer years = 8;

        //Logging the information
        logger.info("It has been {} years since I began coding.", years);
    }


}

