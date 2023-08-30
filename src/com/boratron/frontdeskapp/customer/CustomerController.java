package com.boratron.frontdeskapp.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerController {
    private final List<Customer> customers;
    private final CustomerView customerView;

    public CustomerController() {
        this.customers = new ArrayList<>();
        this.customerView = new CustomerView();
    }

    public void viewCustomers() {
        this.customerView.printResults(this.customers);
    }

    public Optional<Customer> findByPhoneNumber(String phoneNumber) {
        for (Customer customer : this.customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return Optional.of(customer);
            }
        }

        return Optional.empty();
    }

    public void createCustomer(Customer newCustomer) {
        Optional<Customer> customer = this.findByPhoneNumber(newCustomer.getPhoneNumber());

        if (customer.isEmpty()) {
            System.out.println("\nNew Customer added...");
            this.customers.add(newCustomer);
            return;
        }

        this.customerView.printResult("\nError. Phone number already exist...\n");
    }
}
