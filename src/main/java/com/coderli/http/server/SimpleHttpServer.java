package com.coderli.http.server;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author li.hzh
 * @date 2017-09-03 00:01
 */
@Slf4j
public class SimpleHttpServer implements HttpServer {
    
    private ServerSocket serverSocket;
    
    
    @Override
    public void bind(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            InetSocketAddress address = (InetSocketAddress) socket.getRemoteSocketAddress();
            log.info("Remote socket address is {}.", address.getHostString());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), Charset.forName("gbk")));) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
    }
    
}
