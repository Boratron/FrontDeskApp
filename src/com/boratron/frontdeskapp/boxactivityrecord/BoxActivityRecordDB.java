package com.boratron.frontdeskapp.boxactivityrecord;

import java.util.ArrayList;
import java.util.List;

public class BoxActivityRecordDB {
    private final List<BoxActivityRecord> boxActivityRecords;

    public BoxActivityRecordDB() {
        this.boxActivityRecords = new ArrayList<>();
    }

    public List<BoxActivityRecord> getBoxActivityRecords() {
        return boxActivityRecords;
    }
}
