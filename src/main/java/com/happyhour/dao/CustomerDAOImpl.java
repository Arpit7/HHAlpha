package com.happyhour.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.happyhour.model.Customer;

/**
 * Class for Customer interaction with DB
 * 
 * @author Mohit Bansal
 * Updated By: Arpit Bhargava
 */
public class CustomerDAOImpl implements CustomerDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private Logger log = Logger.getLogger("CustomerDAOImpl");

	public JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		getJdbcTemplate();
	}

	public int insertCustomer(Customer customer) {

		log.info("inserting the customer");

		String sql = "INSERT INTO Customer "
				+ "(user_id, user_name, address, password, pincode,phone_num,email,created_date) VALUES (?, ?, ?,?,?,?,?,?)";

		int count = 0;
		try {
			count = jdbcTemplate.update(sql,
					new Object[] { customer.getUserId(), customer.getUserName(), customer.getAddress(),
							customer.getPassword(), customer.getPincode(), customer.getPhoneNum(), customer.getEmail(),
							customer.getCreatedDate() });
		} catch (Exception e) {
			log.info("error in inserting customer :" + e.getMessage());
		}

		return count;
	}

	public List<Customer> getCustomers() {
		String sql = "select id,user_id from Customer";
		log.info("Retrieving All customer userId and Ids");

		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			public Customer mapRow(ResultSet rs, int rownumber) throws SQLException {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setUserId(rs.getString(2));
				return c;
			}
		});

	}
	
	public Customer getCustomerInfo(String userId)
	{
		String sql="select * from customer where user_id = ?";
		log.info("Retrieving  customer using userId ");
		return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Customer.class);
	}
	
	public int updateCustomerPassword(String userId,String password)
	{
		String sql="UPDATE Customer SET password= ? and updated_date=? WHERE user_id = ?";
		log.info("Updating Password of customer having userId="+userId);
		int count=0;
		try{
		count=jdbcTemplate.update(sql, new Object[]{password,new Date(),userId});
		}
		catch(Exception e)
		{
			log.info("Not able to update password ");
		}
		
		return count;
		
	}
	
	public List<Customer> getCustomersUsingPinCode(int pinCode) {
		String sql = "select id,user_id from Customer where pincode= ?";
		log.info("Retrieving All customer having pincode = "+pinCode);
		return jdbcTemplate.query(sql, new Object[]{pinCode},new RowMapper<Customer>() {

			public Customer mapRow(ResultSet rs, int rownumber) throws SQLException {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setUserId(rs.getString(2));
				return c;
			}
		});

	}
	
	public List<Customer> getCustomersCreatedBefore(Date creationdate) {
		String sql = "select id,user_id from Customer where creationdate < ?";
		log.info("Retrieving All customer who registered before date = "+creationdate);
		return jdbcTemplate.query(sql, new Object[]{creationdate},new RowMapper<Customer>() {

			public Customer mapRow(ResultSet rs, int rownumber) throws SQLException {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setUserId(rs.getString(2));
				return c;
			}
		});

	}
	
	public int updateCustomerEmailId(String userId,String emailId)
	{
		String sql="UPDATE Customer SET email= ? and updated_date=? WHERE user_id = ?";
		log.info("Updating Email id of customer having userId="+userId);
		int count=0;
		try{
		count=jdbcTemplate.update(sql, new Object[]{emailId,new Date(),userId});
		}
		catch(Exception e)
		{
			log.info("Not able to update password ");
		}
		
		return count;
		
	}
	
	

}
