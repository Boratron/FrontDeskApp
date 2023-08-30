package com.boratron.frontdeskapp.boxactivityrecord;

import com.boratron.frontdeskapp.box.Box;
import com.boratron.frontdeskapp.customer.Customer;

import java.util.List;

public class BoxActivityRecordView {
    private void displayRecords(BoxActivityRecord boxActivityRecord) {
        Box box = boxActivityRecord.getBox();
        Customer owner = box.getOwner();

        System.out.println("Box");
        System.out.println("------------------------\n");
        System.out.println("ID: " + box.getId());
        System.out.println("Size: " + box.getSize());
        System.out.println("Date of Storage: " + boxActivityRecord.getDateOfStorage());
        System.out.println("Date of Retrieval: " + boxActivityRecord.getDateOfRetrieval());
        System.out.println("Owner: " + owner.getFirstName() + " " + owner.getLastName());
        System.out.println("Phone Number: " + owner.getPhoneNumber() + "\n");
    }

    public void printResults(List<BoxActivityRecord> boxActivityRecords) {
        System.out.println("\nRecords:");
        System.out.println("----------");
        for (BoxActivityRecord boxActivityRecord: boxActivityRecords) {
            this.displayRecords(boxActivityRecord);
        }
    }
}
