package com.happyhour.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.happyhour.model.Merchant;

/**
 * @author arpit.bhargava
 *
 */
public class MerchantDAOImpl extends JdbcDaoSupport implements MerchantDAO {

	private Logger log = Logger.getLogger("MerchantDAOImpl");

	@Override
	public List<Merchant> getRegisteredMerchant() {
		String sql = "select id,merchant_id from Merchant";
		log.info("Retrieving All Registered Merchats");

		return getJdbcTemplate().query(sql, new RowMapper<Merchant>() {

			public Merchant mapRow(ResultSet rs, int rownumber)
					throws SQLException {
				Merchant m = new Merchant();
				m.setId(rs.getInt(1));
				m.setMerchantId(rs.getInt(2));
				return m;
			}
		});

	}

	@Override
	public Merchant getMerchantInfo(int merchantId) {

		String sql = "select * from merchant where merchant_id = ?";
		log.info("Retrieving  Merchant using userId ");
		return getJdbcTemplate().queryForObject(sql,
				new Object[] { merchantId }, new MerchantRowMapper());

	}

	@Override
	public List<Merchant> getMerchantRegisteredBefore(Date creationDate) {

		String sql = "select id,merchant_id from merchant where created_date < ?";
		log.info("Retrieving All Merchant who registered before date = "
				+ creationDate);
		return getJdbcTemplate().query(sql, new Object[] { creationDate },
				new RowMapper<Merchant>() {

					public Merchant mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Merchant m = new Merchant();
						m.setId(rs.getInt(1));
						m.setMerchantId(rs.getInt(2));
						return m;
					}
				});

	}

	@Override
	public List<Merchant> getMerchantRegisteredAfter(Date creationDate) {

		String sql = "select id,merchant_id from merchant where created_date > ?";
		log.info("Retrieving All Merchant who registered before date = "
				+ creationDate);
		return getJdbcTemplate().query(sql, new Object[] { creationDate },
				new RowMapper<Merchant>() {

					public Merchant mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Merchant m = new Merchant();
						m.setId(rs.getInt(1));
						m.setMerchantId(rs.getInt(2));
						return m;
					}
				});

	}
	
	public static final class MerchantRowMapper implements RowMapper<Merchant>{

		@Override
		public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Merchant m=new Merchant();
			m.setCreatedDate(rs.getDate("created_date"));
			m.setEmailId(rs.getString("email"));
			m.setId(rs.getInt("id"));
			m.setMerchantId(rs.getInt("merchant_id"));
			m.setMerchantName(rs.getString("merchant_name"));
			m.setPassword(rs.getString("password"));
			m.setPhoneNumber(rs.getInt("phone_num"));
			m.setUpdatedDate(rs.getDate("updated_date"));
			return m;
		}
		
		
		
		
	}

}
