package com.boratron.frontdeskapp.boxactivityrecord;

import com.boratron.frontdeskapp.box.Box;

import java.time.LocalDate;

public class BoxActivityRecord {
    private final Box box;
    LocalDate dateOfStorage;
    LocalDate dateOfRetrieval;

    public BoxActivityRecord(Box box, LocalDate dateOfStorage) {
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

    public LocalDate getDateOfStorage() {
        return dateOfStorage;
    }

    public LocalDate getDateOfRetrieval() {
        return dateOfRetrieval;
    }

    public void setDateOfRetrieval(LocalDate dateOfRetrieval) {
        this.dateOfRetrieval = dateOfRetrieval;
    }
}
