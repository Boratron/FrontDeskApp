package com.boratron.frontdeskapp.storagearea;

import java.util.List;

public class StorageAreaRepository {
    private final StorageAreaDB storageAreaDB;

    public StorageAreaRepository() {
        this.storageAreaDB = new StorageAreaDB();
    }

    public List<StorageArea> getStorageAreas() {
        return this.storageAreaDB.getStorageAreas();
    }

//    public O

    public StorageArea createStorageArea(StorageArea storageArea) {
        this.getStorageAreas().add(storageArea);

        return storageArea;
    }
}
