package com.mongo.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ManiServiceImpl implements ManiService{

    private final ManiRepository maniRepository;

    private final MongoTemplate mongoTemplate;

    public ManiServiceImpl(ManiRepository maniRepository, MongoTemplate mongoTemplate) {
        this.maniRepository = maniRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Mani> getAllManis() {
        return maniRepository.findAll();
    }

    @Override
    public Mani saveMani(Mani mani) {
        return maniRepository.save(mani);
    }

    @Override
    public Mani getManiByName(String name) {
        return maniRepository.findByName(name);
    }

    @Override
    public Mani getManiByPhone(String phone) {
        return maniRepository.findByPhone(phone);
    }

    @Override
    public List<Mani> getManiByStore( String inputStoreKey) {
        Query query = new Query();

        if (inputStoreKey != null && !inputStoreKey.isEmpty()) {
            query.addCriteria(Criteria.where("storeKeys").is(inputStoreKey));
        }

        log.info(query.toString());
        return mongoTemplate.find(query, Mani.class);
    }
}
