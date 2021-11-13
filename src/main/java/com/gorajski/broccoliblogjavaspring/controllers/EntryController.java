package com.gorajski.broccoliblogjavaspring.controllers;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import com.gorajski.broccoliblogjavaspring.services.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EntryController {

    private static final Logger log = LoggerFactory.getLogger(EntryController.class);
    private final EntryService service;

    public EntryController(EntryService service) {
        this.service = service;
    }

    @RequestMapping("/entries")
    public String getEntries(ModelMap modelMap) {
        log.info("GET /entries called.");
        List<Entry> entries = service.findAll();
        modelMap.put("entries", entries);

        return "index";
    }

    @RequestMapping("/entries/new")
    public String newEntry() {
        log.info("GET /entries/new called.");

        return "new";
    }


    @RequestMapping(value = "/entries", method = RequestMethod.POST)
    public String postEntry(@RequestParam("title") String title, @RequestParam("body") String body) {
        log.info("POST /entries called.");
        service.create(title, body);

        return "redirect:/entries";
    }

    @RequestMapping("/entries/{id}")
    public String showEntry(@PathVariable("id") Long id, ModelMap modelMap) {
        log.info("GET /entries/" + id + " called.");
        Entry entry = service.findById(id);
        modelMap.put("entry", entry);

        return "show";
    }

    @RequestMapping("/entries/{id}/edit")
    public String editEntry(@PathVariable("id") Long id, ModelMap modelMap) {
        log.info("GET /entries/" + id + "/edit called.");
        Entry entry = service.findById(id);
        modelMap.put("entry", entry);

        return "edit";
    }

    @RequestMapping(value = "/entries/{id}", method = RequestMethod.PUT)
    public String updateEntry(@PathVariable("id") Long id, @RequestParam("title") String title, @RequestParam("body") String body) {
        log.info("PUT /entries/" + id + " called.");
        service.update(id, title, body);

        return "redirect:/entries/" + id;
    }
}