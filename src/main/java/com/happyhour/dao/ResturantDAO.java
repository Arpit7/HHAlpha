package com.happyhour.dao;

import java.util.List;

import com.happyhour.model.Resturant;

/**
 * Interface for Resturant interaction with DB
 * 
 * @author Mohit Bansal
 */
public interface ResturantDAO {

	public int insertResturant(Resturant resturant);

	public List<Resturant> getRegisteredResturants();

}
