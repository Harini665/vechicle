
package com.vechicle.rescue.dao;

import com.vechicle.rescue.entity.Customer;

public class CustomerDAO extends GenericDAO<Customer> {

    public CustomerDAO() {
        super(Customer.class);
    }
}