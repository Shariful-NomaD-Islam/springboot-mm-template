package com.nomad.m1.core;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ComponentTest {

    @PostConstruct
    void init() {
        System.out.println("From m1");
    }
}
