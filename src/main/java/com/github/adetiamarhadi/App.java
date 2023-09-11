package com.github.adetiamarhadi;

import org.apache.thrift.server.TServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Start the Thrift server
        TServer thriftServer = (TServer) context.getBean("thriftServer");
        thriftServer.serve();
    }
}
