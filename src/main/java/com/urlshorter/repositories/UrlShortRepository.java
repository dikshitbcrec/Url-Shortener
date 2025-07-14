package com.urlshorter.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.urlshorter.entities.UrlEntity;

public interface UrlShortRepository extends MongoRepository<UrlEntity, String> {

}
