package com.postgres.crud.h2database;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SonyServiceServiceImpl implements SonyService{

    @Autowired
    SonyRepository sonyRepository;

    @Override
    public Sony saveSony(Sony sony) {
        return sonyRepository.save(sony);
    }

    @Override
    public Sony getSonyById(Long id) {
        return sonyRepository.getReferenceById(id);
    }

    @Override
    public void deleteSonyById(Long id) {
        sonyRepository.delete(getSonyById(id));
    }

    @Override
    public List<Sony> getAllSony() {
        return sonyRepository.findAll();
    }

    @Override
    public Sony patchUpdate(Long id, Map<String, Object> updates) {
        getSonyById(id);
        return null;
    }

    @Override
    public Sony putUpdate(Sony sony) {
        Sony sonyById = getSonyById(sony.getId());
        if(null != sonyById )
        {
            sonyById = Sony.builder().name(sony.getName()).active(sony.isActive()).build();
            return saveSony(sonyById);
        }
        return null;
    }


}
