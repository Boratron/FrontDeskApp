package com.boratron.frontdeskapp.storagefacility;

import com.boratron.frontdeskapp.box.Box;
import com.boratron.frontdeskapp.boxactivityrecord.BoxActivityRecord;
import com.boratron.frontdeskapp.customer.Customer;
import com.boratron.frontdeskapp.storagearea.StorageArea;

import java.util.List;

public class StorageFacilityView {
    public void printResults(List<StorageFacility> storageFacilities) {
        System.out.println("\nStorage Facilities");
        System.out.println("--------------------");
        for (StorageFacility storageFacility : storageFacilities) {
            System.out.println("//-------------------//");
            System.out.println("Storage Facility: " + storageFacility.getName());
            System.out.println("\n-----Storage Areas-----");
            for (StorageArea storageArea: storageFacility.getStorageAreas()) {
                System.out.println("\nArea Size: " + storageArea.getSize());
                System.out.println("Number of Boxes: " + storageArea.getBoxes().size());
                System.out.println("Max Capacity: " + storageArea.getMaxCapacity());
                if (storageArea.checkAvailability()) {
                    System.out.println("Availability: Available (Not yet full)");
                } else {
                    System.out.println("Availability: Not Available (Full)");
                }
            }
            System.out.println("//-------------------//\n");
        }
    }

    public void displayRecords(List<BoxActivityRecord> boxActivityRecords) {
        System.out.println("\nRecords:");
        System.out.println("----------");
        for (BoxActivityRecord boxActivityRecord: boxActivityRecords) {
            Box box = boxActivityRecord.getBox();
            Customer owner = box.getOwner();

            System.out.println("Box ID: " + box.getId());
            System.out.println("Box Size: " + box.getSize());
            System.out.println("Date of Storage: " + boxActivityRecord.getDateOfStorage());

            if (boxActivityRecord.getDateOfRetrieval() == null) {
                System.out.println("Date of Retrieval: N/A");
            } else {
                System.out.println("Date of Retrieval: " + boxActivityRecord.getDateOfRetrieval());

            }

            System.out.println("Owner: " + owner.getFirstName() + " " + owner.getLastName());
            System.out.println("Phone Number: " + owner.getPhoneNumber() + "\n");
        }
    }
}
