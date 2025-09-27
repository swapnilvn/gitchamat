package com.mongo.crud;

import java.util.List;

public interface ManiService {

    List<Mani> getAllManis();

    Mani saveMani(Mani mani);

    Mani getManiByName(String name);

    Mani getManiByPhone(String phone);

    List<Mani> getManiByStore(String number);
}
