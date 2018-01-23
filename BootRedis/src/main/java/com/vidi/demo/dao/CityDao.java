package com.vidi.demo.dao;

import com.vidi.demo.domain.City;

import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/1/2 13:58
 * @Descripton : the city Dao,operate the database by this interface
 */
public interface CityDao {


	/**
	 * get all city information
	 *
	 * @return the city list
	 */
	List<City> findAllCity();

	/**
	 * search city information from database
	 *
	 * @param id
	 * @return the certain city
	 */
	City findCityById(Long id);

	/**
	 * insert the city information to the database
	 *
	 * @param city
	 * @return the id of the city to be inserted
	 */
	Long saveCity(City city);

	/**
	 * update the city information in database
	 *
	 * @param city
	 * @return the id of city to be updated
	 */
	Long updateCity(City city);

	/**
	 * delete the city from  database
	 *
	 * @param id
	 * @return the id of city to be deleted
	 */
	Long deleteCity(Long id);

}
