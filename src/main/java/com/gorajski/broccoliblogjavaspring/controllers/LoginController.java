package com.gorajski.broccoliblogjavaspring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(EntryController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        log.info("GET /login called.");

        return "login";
    }
}
