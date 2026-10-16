package com.vechicle.rescue.service;

import com.vechicle.rescue.dao.CustomerDAO;
import com.vechicle.rescue.entity.Customer;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    public void registerCustomer(
            String customerName,
            String phoneNumber,
            String email) {

        // Basic validation
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            System.out.println("Phone number cannot be empty.");
            return;
        }

        if (email == null || email.trim().isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }

        // Create Customer object
        Customer customer = new Customer(
                0,
                customerName,
                phoneNumber,
                email
        );

        // Save customer
        Customer savedCustomer = customerDAO.save(customer);

        // Display result
        System.out.println();
        System.out.println("Customer registered successfully!");
        System.out.println("Customer ID: " + savedCustomer.getCustomerId());
        System.out.println("Name: " + savedCustomer.getCustomerName());
        System.out.println("Phone: " + savedCustomer.getPhoneNumber());
        System.out.println("Email: " + savedCustomer.getEmail());
    }

    public void viewCustomers() {

  
    	var customers = customerDAO.getAll();

    	if (customers.isEmpty()) {
    	    System.out.println("Customer not found.");
    	    return;
    	}

    	System.out.println();
    	System.out.println("============ CUSTOMERS DETAILS ============");

    	for (Customer customer : customers) {
    	    System.out.println("Customer ID: " + customer.getCustomerId());
    	    System.out.println("Name: " + customer.getCustomerName());
    	    System.out.println("Phone: " + customer.getPhoneNumber());
    	    System.out.println("Email: " + customer.getEmail());
    	    System.out.println("-------------------------------------------");
    	}
   

    	}

		
	}