package com.coderli.http;

import com.coderli.http.server.HttpServer;
import com.coderli.http.server.SimpleHttpServer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author li.hzh
 * @date 2017-09-02 23:55
 */
@Slf4j
public class HttpServerBootStrap {
    
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = new SimpleHttpServer();
        try {
            int port = 7080;
            httpServer.bind(port);
            log.info("Http Server started at port {}.", port);
        } catch (IOException e) {
            log.error("", e);
            e.printStackTrace();
        }
    }
    
}
