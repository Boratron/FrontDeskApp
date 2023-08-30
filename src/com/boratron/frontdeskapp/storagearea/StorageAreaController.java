package com.boratron.frontdeskapp.storagearea;

import com.boratron.frontdeskapp.box.Box;

public class StorageAreaController {
    private final StorageAreaRepository storageAreaRepository;
    private final StorageAreaView storageAreaView;

    public StorageAreaController() {
        this.storageAreaRepository = new StorageAreaRepository();
        this.storageAreaView = new StorageAreaView();
    }
}
