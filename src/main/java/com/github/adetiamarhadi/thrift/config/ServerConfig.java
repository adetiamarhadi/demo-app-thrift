package com.github.adetiamarhadi.thrift.config;

import com.github.adetiamarhadi.thrift.MyService;
import com.github.adetiamarhadi.thrift.impl.MyServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ServerConfig {

    @Bean
    public MyService.Iface myServiceHandler() {
        return new MyServiceImpl();
    }

    @Bean
    public TServer thriftServer(MyService.Iface myServiceHandler) throws TTransportException {
        TServerSocket tServerSocket = new TServerSocket(9090);
        TThreadPoolServer.Args serverArgs = new TThreadPoolServer.Args(tServerSocket);
        serverArgs.processor(new MyService.Processor<>(myServiceHandler));

        return new TThreadPoolServer(serverArgs);
    }
}
