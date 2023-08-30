package com.boratron.frontdeskapp.boxactivityrecord;

public class BoxActivityRecordController {
    private final BoxActivityRecordRepository boxActivityRecordRepository;
    private final BoxActivityRecordView boxActivityRecordView;

    public BoxActivityRecordController() {
        this.boxActivityRecordRepository = new BoxActivityRecordRepository();
        this.boxActivityRecordView = new BoxActivityRecordView();
    }

    public void viewRecords() {
        this.boxActivityRecordView.printResults(this.boxActivityRecordRepository.getBoxActivityRecords());
    }
}
