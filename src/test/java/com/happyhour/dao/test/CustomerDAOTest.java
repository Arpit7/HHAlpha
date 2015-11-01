package com.happyhour.dao.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:application-*.xml" })
@Transactional  
@RunWith(SpringJUnit4ClassRunner.class)  
public class CustomerDAOTest {

	
	@Test
	public void testMethod()
	{
		Assert.assertTrue(true);
	}
	
	
}
