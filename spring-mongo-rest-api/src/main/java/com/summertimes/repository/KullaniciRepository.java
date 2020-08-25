package com.summertimes.repository;

import com.summertimes.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository<Kullanici,String> {


}
