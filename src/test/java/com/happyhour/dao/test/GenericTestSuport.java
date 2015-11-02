package com.happyhour.dao.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arpit.bhargava
 *
 */
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@ContextConfiguration({ "classpath:/application-context.xml" })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericTestSuport {

}
