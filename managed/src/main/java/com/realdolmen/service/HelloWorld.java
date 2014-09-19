package com.realdolmen.service;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {
    String sayHello(String name);
}
