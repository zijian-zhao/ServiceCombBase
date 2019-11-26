package com.redteamobile.servicecomb_base.controller;

import org.apache.servicecomb.tracing.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 使用@Span注释的自定义打点功能只支持和Java Chassis调用请求同一线程的方法调用。
 * 添加@Span注释的方法必须是Spring管理的Bean，否则需要按这里提到的方法配置
 * 定制打点
 * 在需要定制打点的方法上添加@Span注释
 * see more at https://github.com/apache/servicecomb-docs/blob/master/java-chassis-reference/zh_CN/general-development/customized-tracing.md
 */
@Component
public class SlowRepoImpl {
    private static final Logger logger = LoggerFactory.getLogger(SlowRepoImpl.class);

    private final Random random = new Random();

    @Span
    public String crawl() throws InterruptedException {
        logger.info("in /crawl");
        Thread.sleep(random.nextInt(200));
        return "crawled";
    }
}
