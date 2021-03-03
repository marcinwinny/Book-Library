package com.marcinwinny.booklibrary.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorControllerTest {

    @Autowired
    private AuthorController authorController;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertNotNull(authorController);
    }

}