package com.boratron.frontdeskapp.boxactivityrecord;

import java.util.List;

public class BoxActivityRecordRepository {
    private final BoxActivityRecordDB boxActivityRecordDB;

    public BoxActivityRecordRepository() {
        this.boxActivityRecordDB = new BoxActivityRecordDB();
    }

    public List<BoxActivityRecord> getBoxActivityRecords() {
        return this.boxActivityRecordDB.getBoxActivityRecords();
    }
}
