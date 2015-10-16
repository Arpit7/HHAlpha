package com.happyhour.dao;

import java.util.Date;
import java.util.List;

import com.happyhour.model.Customer;

/**
 * Interface for Customer interaction with DB
 * 
 * @author Mohit Bansal
 */
public interface CustomerDAO {

	public int insertCustomer(Customer customer);

	public List<Customer> getCustomers();

	public Customer getCustomerInfo(String userId);

	public int updateCustomerPassword(String userId, String password);

	public List<Customer> getCustomersUsingPinCode(int pinCode);

	public List<Customer> getCustomersCreatedBefore(Date creationdate);

	public int updateCustomerEmailId(String userId, String emailId);

}
