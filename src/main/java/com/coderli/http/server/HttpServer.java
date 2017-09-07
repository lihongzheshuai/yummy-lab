package com.coderli.http.server;

import java.io.IOException;

/**
 * @author li.hzh
 * @date 2017-09-03 00:00
 */
public interface HttpServer {
    
    /**
     * 绑定到指定端口
     *
     * @param port
     */
    void bind(int port) throws IOException;
    
}
