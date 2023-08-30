package com.boratron.frontdeskapp.storagefacility;

import java.util.List;
import java.util.Optional;

public class StorageFacilityRepository {
    private final StorageFacilityDB storageFacilityDB;

    public StorageFacilityRepository() {
        this.storageFacilityDB = new StorageFacilityDB();
    }

    public List<StorageFacility> getStorageFacilities() {
        return this.storageFacilityDB.getStorageFacilities();
    }

    public Optional<StorageFacility> findByName(String nameSearch) {
        for (StorageFacility storageFacility : this.getStorageFacilities()) {
            if (storageFacility.getName().equals(nameSearch)) {
                return Optional.of(storageFacility);
            }
        }

        return Optional.empty();
    }

    public StorageFacility createStorageFacility(StorageFacility storageFacility) {
        this.getStorageFacilities().add(storageFacility);

        return storageFacility;
    }
}
