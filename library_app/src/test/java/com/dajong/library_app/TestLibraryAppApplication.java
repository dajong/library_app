package com.dajong.library_app;

import org.springframework.boot.SpringApplication;

public class TestLibraryAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(LibraryAppApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
