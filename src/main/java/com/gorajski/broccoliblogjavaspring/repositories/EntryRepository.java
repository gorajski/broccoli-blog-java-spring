package com.gorajski.broccoliblogjavaspring.repositories;

import com.gorajski.broccoliblogjavaspring.models.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
}
