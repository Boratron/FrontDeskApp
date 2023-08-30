package com.boratron.frontdeskapp.storagearea;

import java.util.ArrayList;
import java.util.List;

public class StorageAreaDB {
    private final List<StorageArea> storageAreas;

    public StorageAreaDB() {
        this.storageAreas = new ArrayList<>();
    }

    public List<StorageArea> getStorageAreas() {
        return storageAreas;
    }
}
