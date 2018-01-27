package com.slf4j.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

public class Ali_logging {


/*
阿里日志规范：file:///C:/Users/Administrator/Desktop/Java_%E9%98%BF%E9%87%8C%E8%A7%84%E8%8C%83.pdf
slf4j 跟logback关系： http://ifeve.com/slf4j-manual/
logback概述：https://www.cnblogs.com/warking/p/5710303.html
layout 详细描述：http://blog.csdn.net/doraemon_wu/article/details/52040859
 */
    @Test
    public void xml() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        try {
            throw new NullPointerException();
        } catch (Exception e) {
            logger.info("这里是哟啊打印的日志：{}",1,e);
        }
    }
}
