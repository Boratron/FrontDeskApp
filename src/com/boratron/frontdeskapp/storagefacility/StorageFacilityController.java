package com.boratron.frontdeskapp.storagefacility;

import com.boratron.frontdeskapp.box.Box;
import com.boratron.frontdeskapp.common.Size;
import com.boratron.frontdeskapp.storagearea.StorageArea;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageFacilityController {
    private final List<StorageFacility> storageFacilities;
    private final StorageFacilityView storageFacilityView;

    public StorageFacilityController() {
        this.storageFacilities = new ArrayList<>();
        this.storageFacilityView = new StorageFacilityView();

        // -- defaults -- //
        StorageFacility storageFacilityA = new StorageFacility("A");

        storageFacilityA.getStorageAreas().add(new StorageArea(Size.SMALL, 15));
        storageFacilityA.getStorageAreas().add(new StorageArea(Size.MEDIUM, 10));
        storageFacilityA.getStorageAreas().add(new StorageArea(Size.LARGE, 5));

        StorageFacility storageFacilityB = new StorageFacility("B");

        storageFacilityB.getStorageAreas().add(new StorageArea(Size.SMALL, 1));
        storageFacilityB.getStorageAreas().add(new StorageArea(Size.MEDIUM, 1));
        storageFacilityB.getStorageAreas().add(new StorageArea(Size.LARGE, 1));


        StorageFacility storageFacilityC = new StorageFacility("C");

        storageFacilityC.getStorageAreas().add(new StorageArea(Size.SMALL, 20));
        storageFacilityC.getStorageAreas().add(new StorageArea(Size.MEDIUM, 15));
        storageFacilityC.getStorageAreas().add(new StorageArea(Size.LARGE, 10));

        this.storageFacilities.add(storageFacilityA);
        this.storageFacilities.add(storageFacilityB);
        this.storageFacilities.add(storageFacilityC);
        // ----- //
    }

    public void viewStorageFacilities() {
        this.storageFacilityView.printResults(this.storageFacilities);
    }

    public void viewStorageFacility(String name) {
        Optional<StorageFacility> storageFacilitySearch = this.findStorageFacilityByName(name.toUpperCase());

        if (storageFacilitySearch.isPresent()) {
            this.storageFacilityView.displayFacility(storageFacilitySearch.get());
        } else {
            System.out.println("\nStorage Facility '" + name + "' does not exist");
        }
    }

    public void viewStorageFacilityRecords(String name) {
        Optional<StorageFacility> storageFacilitySearch = this.findStorageFacilityByName(name.toUpperCase());

        if (storageFacilitySearch.isPresent()) {
            System.out.println("\nStorage Facility: " + storageFacilitySearch.get().getName());
            this.storageFacilityView.displayRecords(storageFacilitySearch.get().getBoxActivityRecords());
        } else {
            System.out.println("Storage Facility '" + name + "' does not exist");
        }
    }

    public Optional<StorageFacility> findStorageFacilityByName(String name) {
        for (StorageFacility storageFacility : this.storageFacilities) {
            if (storageFacility.getName().equals(name)) {
                return Optional.of(storageFacility);
            }
        }

        return Optional.empty();
    }

    public Optional<Box> findBoxById(int boxId) {
        for (StorageFacility storageFacility : this.storageFacilities) {
            for (StorageArea storageArea : storageFacility.getStorageAreas()) {
                for (Box box : storageArea.getBoxes()) {
                    if (boxId == box.getId()) {
                        return Optional.of(box);
                    }
                }
            }
        }

        return Optional.empty();
    }

    public Optional<StorageFacility> findStorageFacilityOfBox(Box boxSearch) {
        for (StorageFacility storageFacility : this.storageFacilities) {
            for (StorageArea storageArea : storageFacility.getStorageAreas()) {
                for (Box box : storageArea.getBoxes()) {
                    if (boxSearch.getId() == box.getId()) {
                        return Optional.of(storageFacility);
                    }
                }
            }
        }

        return Optional.empty();
    }

    public Optional<StorageArea> findStorageAreaOfBox(Box boxSearch) {
        for (StorageFacility storageFacility : this.storageFacilities) {
            for (StorageArea storageArea : storageFacility.getStorageAreas()) {
                for (Box box : storageArea.getBoxes()) {
                    if (boxSearch.getId() == box.getId()) {
                        return Optional.of(storageArea);
                    }
                }
            }
        }

        return Optional.empty();
    }
}
