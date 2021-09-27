package com.nomad.m2.core;

import com.nomad.common.Util;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ComponentTest {

    @PostConstruct
    void init() {
        System.out.println("From m2");
        Util.test();
    }
}
