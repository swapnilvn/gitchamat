package com.mongo.crud;

import jakarta.annotation.Generated;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Builder
public class Mani {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<String> storeKeys;

    public Mani() {
    }
    public Mani(String id, String name, String email, String phone, String address, List<String> storeKeys) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.storeKeys = storeKeys;
    }
}
