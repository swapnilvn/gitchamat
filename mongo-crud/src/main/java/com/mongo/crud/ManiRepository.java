package com.mongo.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManiRepository extends MongoRepository<Mani, String> {

    Mani findByName(String name);

    Mani findByPhone(String phone);

    @Query("{ '$or': [ { 'storeKeys': ?0 }, { 'storeKeys': null }, { 'storeKeys': { $size: 0 } } ] }")
    List<Mani> findByStoreKeysOrIgnore(String storeKey);
}
