package com.boratron.frontdeskapp.customer;

import java.util.List;

public class CustomerView {
    private void displayCustomer(Customer customer) {
        System.out.println("Name: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Phone Number: " + customer.getPhoneNumber() + "\n");
    }

    public void printResult(String message) {
        System.out.println(message);
    }

    public void printResults(List<Customer> customers) {
        System.out.println("\nCustomers:");
        System.out.println("------------");
        for (Customer customer: customers) {
            this.displayCustomer(customer);
        }
    }

    public void printResult(String message, Customer customer) {
        System.out.println(message);
        this.displayCustomer(customer);
    }
}
