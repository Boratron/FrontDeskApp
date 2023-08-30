package com.boratron.frontdeskapp;

import com.boratron.frontdeskapp.box.Box;
import com.boratron.frontdeskapp.common.Size;
import com.boratron.frontdeskapp.customer.Customer;
import com.boratron.frontdeskapp.customer.CustomerController;
import com.boratron.frontdeskapp.storagearea.StorageArea;
import com.boratron.frontdeskapp.storagefacility.StorageFacility;
import com.boratron.frontdeskapp.storagefacility.StorageFacilityController;
import com.boratron.frontdeskapp.utility.Reader;

import java.util.Optional;

public class Main {
    private static final CustomerController customerController = new CustomerController();
    private static final StorageFacilityController storageFacilityController = new StorageFacilityController();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n-----------------");
            System.out.println("Front Desk App");
            System.out.println("-----------------\n");

            System.out.println("Press 1 to create a new storage customer");
            System.out.println("Press 2 to store a customer's box");
            System.out.println("Press 3 to retrieve a customer's box");
            System.out.println("Press 4 to view all storage facilities");
            System.out.println("Press 5 to view a storage facility");
            System.out.println("Press 6 to view a storage facility's records");
            System.out.println("Press 7 to view all customers");
            System.out.println("Press any key to exit the application");

            String optionInput = Reader.readString("\nEnter option");

            switch (optionInput) {
                case "1" -> createCustomer();
                case "2" -> storeCustomerBox();
                case "3" -> retrieveCustomerBox();
                case "4" -> viewStorageFacilities();
                case "5" -> viewStorageFacility();
                case "6" -> viewStorageFacilityRecords();
                case "7" -> viewCustomers();
                default -> {
                    System.out.println("\nGoodbye...");
                    running = false;
                }
            }
        }
    }

    public static void viewCustomers() {
        customerController.viewCustomers();
    }
    public static void createCustomer() {
        String firstName = Reader.readString("Enter first name");
        String lastName = Reader.readString("Enter last name");
        String phoneNumber = Reader.readString("Enter phone number");

        Customer customer = new Customer(firstName, lastName, phoneNumber);

        customerController.createCustomer(customer);
    }

    public static void storeCustomerBox() {
        String customerPhoneNumber = Reader.readString("Enter customer's phone number");

        Optional<Customer> customerSearch = customerController.findByPhoneNumber(customerPhoneNumber);

        if (customerSearch.isEmpty()) {
            System.out.println("\nCustomer with phone number " + customerPhoneNumber + " does not exist...");

            return;
        }

        String storageFacilityName = Reader.readString("Enter facility name");

        Optional<StorageFacility> storageFacilitySearch = storageFacilityController.findStorageFacilityByName(storageFacilityName.toUpperCase());

        if (storageFacilitySearch.isPresent()) {
            System.out.println("\nPress 1 for Small");
            System.out.println("Press 2 for Medium");
            System.out.println("Press 3 for Large");

            String sizeOption = Reader.readString("Choose the size of customer's box");
            Size size;

            label:
            while (true) {
                switch (sizeOption) {
                    case "1":
                        size = Size.SMALL;
                        break label;
                    case "2":
                        size = Size.MEDIUM;
                        break label;
                    case "3":
                        size = Size.LARGE;
                        break label;
                }

                System.out.println("\nInvalid option...");

                System.out.println("\nPress 1 for Small");
                System.out.println("Press 2 for Medium");
                System.out.println("Press 3 for Large");

                sizeOption = Reader.readString("Choose the size of the customer's box again");
            }

            Box box = new Box(size, customerSearch.get());

            StorageFacility storageFacility = storageFacilitySearch.get();

            if (storageFacility.storeBox(box)) {
                System.out.println("\nBox with ID of " + box.getId() + " is now in stored in storage facility: " + storageFacility.getName());
            } else {
                System.out.println("\nBox cannot be stored in storage facility: " + storageFacility.getName());
            }
        } else {
            System.out.println("\nStorage Facility: '" + storageFacilityName + "' does not exist...");
        }
    }

    public static void retrieveCustomerBox() {
        String boxId = Reader.readString("Enter box's ID to retrieve it");
        Optional<Box> boxSearch;

        while (true) {
            try {
                boxSearch = storageFacilityController.findBoxById(Integer.parseInt(boxId));
                break;
            } catch (NumberFormatException ignored) {
                System.out.println("ID must be a number");
            }
            boxId = Reader.readString("Enter box's ID again to retrieve it");
        }

        if (boxSearch.isEmpty()) {
            System.out.println("\nBox with ID of '" + boxId + "' either does not exist or has already been retrieved...");

            return;
        }

        Box box = boxSearch.get();

        Optional<StorageArea> storageAreaSearch = storageFacilityController.findStorageAreaOfBox(box);

        if (storageAreaSearch.isEmpty()) {
            System.out.println("\nError Storage Are");

            return;
        }

        StorageArea storageArea = storageAreaSearch.get();

        Optional<StorageFacility> storageFacilitySearch = storageFacilityController.findStorageFacilityOfBox(box);

        if (storageFacilitySearch.isEmpty()) {
            System.out.println("\nError Storage Facility");

            return;
        }

        StorageFacility storageFacility = storageFacilitySearch.get();

        if (storageFacility.retrieveBox(storageArea, box)) {
            System.out.println("\nBox with ID of " + box.getId() + " is now retrieved from storage facility: " + storageFacility.getName());
        } else {
            System.out.println("\nBox with ID of '" + box.getId() + " cannot be retrieved from storage facility: " + storageFacility.getName());
        }
    }

    public static void viewStorageFacilities() {
        storageFacilityController.viewStorageFacilities();
    }

    public static void viewStorageFacility() {
        String storageFacilityName = Reader.readString("Enter storage facility name");

        storageFacilityController.viewStorageFacility(storageFacilityName);
    }

    public static void viewStorageFacilityRecords() {
        String storageFacilityName = Reader.readString("Enter storage facility name");

        storageFacilityController.viewStorageFacilityRecords(storageFacilityName);
    }
}