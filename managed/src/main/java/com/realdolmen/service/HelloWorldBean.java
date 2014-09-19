package com.realdolmen.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
