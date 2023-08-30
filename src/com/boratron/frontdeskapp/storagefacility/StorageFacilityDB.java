package com.boratron.frontdeskapp.storagefacility;

import java.util.ArrayList;
import java.util.List;

public class StorageFacilityDB {
    private final List<StorageFacility> storageFacilities;

    public StorageFacilityDB() {
        this.storageFacilities = new ArrayList<>();
    }

    public List<StorageFacility> getStorageFacilities() {
        return storageFacilities;
    }
}
