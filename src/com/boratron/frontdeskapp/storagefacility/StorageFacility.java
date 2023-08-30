package com.boratron.frontdeskapp.storagefacility;

import com.boratron.frontdeskapp.box.Box;
import com.boratron.frontdeskapp.boxactivityrecord.BoxActivityRecord;
import com.boratron.frontdeskapp.storagearea.StorageArea;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StorageFacility {
    private String name;
    private final List<StorageArea> storageAreas;
    private final List<BoxActivityRecord> boxActivityRecords;

    public StorageFacility(String name) {
        this.name = name;
        this.storageAreas = new ArrayList<>();
        this.boxActivityRecords = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        StorageFacility storageFacility = (StorageFacility) obj;

        return Objects.equals(this.name, storageFacility.name);
    }

    private Optional<StorageArea> searchCompatibleStorageArea(Box box) {
        for (StorageArea storageArea : this.storageAreas) {
            if (box.getSize() == storageArea.getSize() && storageArea.checkAvailability()) {
                return Optional.of(storageArea);
            }
        }

        return Optional.empty();
    }

    private Optional<Box> searchBox(StorageArea storageArea, Box box) {
        if (storageArea.getSize() == box.getSize()) {
            int index = storageArea.getBoxes().indexOf(box);

            if (index < 0) return Optional.empty();

            return Optional.of(storageArea.getBoxes().get(index));
        }

        return Optional.empty();
    }

    private boolean recordDateOfStorage(Box box) {
        return this.boxActivityRecords.add(new BoxActivityRecord(box, LocalDateTime.now()));
    }

    private boolean recordDateOfRetrieval(Box box) {
        int index = this.boxActivityRecords.indexOf(new BoxActivityRecord(box, LocalDateTime.now()));

        if (index > -1) {
            this.boxActivityRecords.get(index).setDateOfRetrieval(LocalDateTime.now());

            return true;
        }

        return false;
    }


    public boolean storeBox(Box box) {
        Optional<StorageArea> storageArea = searchCompatibleStorageArea(box);

        if (storageArea.isPresent()) {
            return storageArea.get().addBox(box) && this.recordDateOfStorage(box);
        } else {
            System.out.println("\nStorage Area is full for " + box.getSize() + " boxes...");
            return false;
        }
    }

    public boolean retrieveBox(StorageArea storageArea, Box box) {
        return storageArea.removeBox(box) && this.recordDateOfRetrieval(box);
    }

    public boolean isAvailable() {
        for (StorageArea storageArea : this.storageAreas) {
            if (storageArea.checkAvailability()) return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StorageArea> getStorageAreas() {
        return storageAreas;
    }

    public List<BoxActivityRecord> getBoxActivityRecords() {
        return boxActivityRecords;
    }
}
