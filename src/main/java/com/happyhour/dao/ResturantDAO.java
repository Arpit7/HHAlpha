package com.happyhour.dao;

import java.util.List;

import com.happyhour.model.Resturant;

/**
 * Interface for Resturant interaction with DB
 * 
 * @author Mohit Bansal
 * Updated By: Arpit Bhargava
 */
public interface ResturantDAO {

	public int insertResturant(Resturant resturant);

	public List<Resturant> getRegisteredResturants();

	public List<Resturant> getResturantsByLocation(int pincode);

	public List<Resturant> getResturantsByName(String restName);

	public List<Resturant> getResturantsByNameAndLocation(int pincode,
			String restName);
	
	public List<Resturant> getResturantsUsingCategory(String category);
	
	public Resturant getResturantUsingId(int resId);
	
	

}
