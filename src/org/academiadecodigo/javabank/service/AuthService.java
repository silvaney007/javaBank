package org.academiadecodigo.javabank.service;

import org.academiadecodigo.javabank.model.Customer;

public interface AuthService {
    /**
     * Authenticates the accessing customer
     *
     * @param id the customer id
     * @return {@code true} if authentication was successful
     */
    boolean authenticate(Integer id);

    /**
     * Gets the accessing customer
     *
     * @return the customer
     */
    Customer getAccessingCustomer();
}

