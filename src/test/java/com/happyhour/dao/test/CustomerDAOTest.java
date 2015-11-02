package com.happyhour.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.happyhour.dao.CustomerDAO;
import com.happyhour.model.Customer;
import com.happyhour.model.object.DummyObjects;

/**
 * @author arpit.bhargava
 *
 */
public class CustomerDAOTest extends GenericTestSuport{

	Customer customer;
	@Autowired
	CustomerDAO customerDAO;

	@Before
	public void setUp() {
		customer = DummyObjects.getCustomerObject();
	}

	@Test
	public void testInsertCustomer() {

		int insertCount = customerDAO.insertCustomer(customer);

		Assert.assertTrue(insertCount == 1);

	}

}
