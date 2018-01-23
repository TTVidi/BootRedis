package com.vidi.demo.service;

import com.vidi.demo.domain.City;

/**
 * @Author : Vidi
 * @Date : 2018/1/2 13:46
 * @Descripton :  City Operation Service
 */
public interface CityService {

	/**
	 * findCityById
	 * <p>
	 * if it exists in cache,return the city
	 * <p>
	 * else search it from database,then update the result to cache
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
	 * delete the city from cache,then update the city information in database
	 *
	 * @param city
	 * @return the id of city to be updated
	 */
	Long updateCity(City city);

	/**
	 * delete the city from cache and database
	 *
	 * @param id
	 * @return the id of city to be deleted
	 */
	Long deleteCity(Long id);


}
