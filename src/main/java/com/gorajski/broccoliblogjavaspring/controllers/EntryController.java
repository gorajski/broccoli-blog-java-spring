package com.gorajski.broccoliblogjavaspring.controllers;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import com.gorajski.broccoliblogjavaspring.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryRepository repo;

    @RequestMapping("/entries")
    public List<Entry> getEntries() {
        return (List<Entry>) repo.findAll();
    }

}
