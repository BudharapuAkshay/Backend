package com.ust.Directors.repository;

import com.ust.Directors.model.Director;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DirectorRepository extends MongoRepository<Director, String> {
}
