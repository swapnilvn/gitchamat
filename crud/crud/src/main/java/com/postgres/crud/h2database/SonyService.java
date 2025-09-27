package com.postgres.crud.h2database;

import java.util.List;
import java.util.Map;

public interface SonyService {
    Sony saveSony(Sony sony);

    Sony getSonyById(Long id);

    void deleteSonyById(Long id);

    List<Sony> getAllSony();

    Sony patchUpdate(Long id, Map<String, Object> updates);

    Sony putUpdate(Sony sony);
}
