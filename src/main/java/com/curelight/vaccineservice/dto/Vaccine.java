package com.curelight.vaccineservice.dto;

import java.util.UUID;

public class Vaccine {
    UUID guid;
    String key;

    public Vaccine() {
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
