package com.gorajski.broccoliblogjavaspring.services;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import com.gorajski.broccoliblogjavaspring.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    EntryRepository repo;

    public List<Entry> findAll() {
        List<Entry> entries = (List<Entry>) repo.findAll();
        return entries;
    }
}
