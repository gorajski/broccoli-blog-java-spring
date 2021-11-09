package com.gorajski.broccoliblogjavaspring.configurations;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import com.gorajski.broccoliblogjavaspring.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyConfig {
    @Autowired
    public void configureDummyEntries(EntryRepository repo) {
        repo.save(new Entry("cool to be a teenager again", "$54,000"));
    }
}
