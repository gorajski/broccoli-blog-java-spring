package com.gorajski.broccoliblogjavaspring.services;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import com.gorajski.broccoliblogjavaspring.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    EntryRepository repo;

    public List<Entry> findAll() {
        List<Entry> entries = (List<Entry>) repo.findAll();
        return entries;
    }

    public Entry findById(Long id) {
        Optional<Entry> entry = repo.findById(id);

        return entry.get();
    }

    public void create(String title, String body) {
        repo.save(new Entry(title, body));
    }

    public void update(Long id, String title, String body) {
        Optional<Entry> entry = repo.findById(id);
        entry.get().setTitle(title);
        entry.get().setBody(body);
        repo.save(entry.get());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
