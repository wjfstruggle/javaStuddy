package com.cdc.StreamFileIO;

/**
 * @program: notes2
 * @description: Java 流(Stream)
 * @author: wujf
 * @create: 2019-08-19 17:20
 **/

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

/**
 * java.io流包含了所有的操作输入输出的类，支持很多格式，包括基本类型，对象，本地化字符集。
 */
public class StreamDemo {
    private static final Logger logger = LogManager.getLogger(StreamDemo.class);

    public static void main(String[] args) throws IOException {
        logger.trace("Entering application.");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("Didn't do it.");
        }
        logger.trace("Exiting application.");
    }
}

class Bar {
    static final Logger logger = LogManager.getLogger(Bar.class.getName());

    public boolean doIt() {
        logger.entry();
        logger.error("Did it again!");
        return logger.exit(false);
    }
}