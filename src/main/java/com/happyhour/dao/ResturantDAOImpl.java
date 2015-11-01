package com.happyhour.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.happyhour.model.Resturant;

/**
 * Class for Resturant interaction with DB
 * 
 * @author Mohit Bansal Updated By: Arpit Bhargava
 */
public class ResturantDAOImpl extends JdbcDaoSupport implements ResturantDAO {

	private Logger log = Logger.getLogger("ResturantDAOImpl");

	public int insertResturant(Resturant resturant) {

		log.info("inserting the Resturant");

		String sql = "INSERT INTO Resturant "
				+ "(rest_name, rest_address, rest_pincode, rest_phone_num, rest_email,rest_login_id,rest_password,rest_type_id,created_date) VALUES (?, ?, ?,?,?,?,?,?,?)";

		int count = 0;
		try {
			count = getJdbcTemplate().update(
					sql,
					new Object[] { resturant.getRestName(),
							resturant.getRestAddress(),
							resturant.getRestPincode(),
							resturant.getRestPhoneNum(),
							resturant.getRestEmail(),
							resturant.getRestLoginId(),
							resturant.getRestPassword(),
							resturant.getRestTypeId(),
							resturant.getCreatedDate() });
		} catch (Exception e) {
			log.info("error in inserting Resturant :" + e.getMessage());
		}

		return count;
	}

	public List<Resturant> getRegisteredResturants() {
		String sql = "select id from Resturant";

		return getJdbcTemplate().query(sql, new RowMapper<Resturant>() {

			public Resturant mapRow(ResultSet rs, int rownumber)
					throws SQLException {
				Resturant r = new Resturant();
				r.setId(rs.getInt(1));

				return r;
			}
		});

	}

	public List<Resturant> getResturantsByLocation(int pincode) {
		String sql = "select id from Resturant where rest_pincode= ?";

		return getJdbcTemplate().query(sql, new Object[] { pincode },
				new RowMapper<Resturant>() {

					public Resturant mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Resturant r = new Resturant();
						r.setId(rs.getInt(1));

						return r;
					}
				});

	}

	public List<Resturant> getResturantsByName(String restName) {
		String sql = "select id from Resturant where rest_name= ?";

		return getJdbcTemplate().query(sql, new Object[] { restName },
				new RowMapper<Resturant>() {

					public Resturant mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Resturant r = new Resturant();
						r.setId(rs.getInt(1));

						return r;
					}
				});

	}

	public List<Resturant> getResturantsByNameAndLocation(int pincode,
			String restName) {
		String sql = "select id from Resturant where  rest_pincode= ? and rest_name= ? ";

		return getJdbcTemplate().query(sql, new Object[] { pincode, restName },
				new RowMapper<Resturant>() {

					public Resturant mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Resturant r = new Resturant();
						r.setId(rs.getInt(1));

						return r;
					}
				});

	}

	public List<Resturant> getResturantsUsingCategory(String category) {

		String sql = "Select rest_Id from Rest_Cat where category=?";

		return getJdbcTemplate().query(sql, new Object[] { category },
				new RowMapper<Resturant>() {

					public Resturant mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						Resturant r = new Resturant();
						r.setId(rs.getInt(1));

						return r;
					}
				});
	}

	public Resturant getResturantUsingId(int resId) {

		String sql = "Select * from Resturant where id=?";

		return getJdbcTemplate().queryForObject(sql, new Object[] { resId },
				new ResturantRowMapper());

	}
	
	
	public static final class ResturantRowMapper implements RowMapper<Resturant>
	{

		@Override
		public Resturant mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Resturant res=new Resturant();
			
			res.setCreatedDate(rs.getDate("created_date"));
			res.setId(rs.getInt("id"));
			res.setRestAddress(rs.getString("rest_address"));
			res.setRestEmail(rs.getString("rest_email"));
			res.setRestLoginId(rs.getString("rest_login_id"));
			res.setRestName(rs.getString("rest_name"));
			res.setRestPassword(rs.getString("rest_password"));
			res.setRestPhoneNum(rs.getInt("rest_phone_num"));
			res.setRestPincode(rs.getInt("rest_pincode"));
			res.setRestTypeId(rs.getInt("rest_type_id"));
			res.setUpdatedDate(rs.getDate("updated_date"));
			
			
			return null;
		}
		
		
		
		
		
		
		
	}

}
