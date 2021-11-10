package com.gorajski.broccoliblogjavaspring.controllers;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import com.gorajski.broccoliblogjavaspring.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EntryController {

    @Autowired
    EntryService service;

    @RequestMapping("/entries")
    public String getEntries(ModelMap modelMap) {
        List<Entry> entries =  service.findAll();
        modelMap.put("entries", entries);

        return "index";
    }
}