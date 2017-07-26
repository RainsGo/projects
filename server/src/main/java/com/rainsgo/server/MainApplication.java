package com.rainsgo.server;


import io.undertow.UndertowOptions;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

/**
 * Created by rain on 17-7-13.
 */
@SpringBootApplication
@MapperScan({"com.rainsgo.server.user.dao", "com.rainsgo.server.log.dao"})
public class MainApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {

        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

        // 这里也可以做其他配置
        factory.addBuilderCustomizers(builder -> builder
                .addHttpListener(8880, "localhost")
                .setServerOption(UndertowOptions.ENABLE_HTTP2, true)
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        exchange.getResponseSender().send("Undertow Running ...");
                    }
                }));

        return factory;
    }

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
    }
}
