package com.github.adetiamarhadi.thrift.impl;

import com.github.adetiamarhadi.thrift.MyService;

public class MyServiceImpl implements MyService.Iface {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
