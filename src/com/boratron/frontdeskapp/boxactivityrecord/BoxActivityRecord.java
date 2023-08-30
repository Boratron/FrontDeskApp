package com.boratron.frontdeskapp.boxactivityrecord;

import com.boratron.frontdeskapp.box.Box;

import java.time.LocalDateTime;

public class BoxActivityRecord {
    private final Box box;
    LocalDateTime dateOfStorage;
    LocalDateTime dateOfRetrieval;

    public BoxActivityRecord(Box box, LocalDateTime dateOfStorage) {
        this.box = box;
        this.dateOfStorage = dateOfStorage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BoxActivityRecord boxActivityRecord = (BoxActivityRecord) obj;

        return this.box.getId() == boxActivityRecord.getBox().getId();
    }

    public Box getBox() {
        return box;
    }

    public LocalDateTime getDateOfStorage() {
        return dateOfStorage;
    }

    public LocalDateTime getDateOfRetrieval() {
        return dateOfRetrieval;
    }

    public void setDateOfRetrieval(LocalDateTime dateOfRetrieval) {
        this.dateOfRetrieval = dateOfRetrieval;
    }
}
