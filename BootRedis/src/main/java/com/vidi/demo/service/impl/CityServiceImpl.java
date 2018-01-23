package com.vidi.demo.service.impl;

import com.vidi.demo.dao.CityDao;
import com.vidi.demo.domain.City;
import com.vidi.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : Vidi
 * @Date : 2018/1/2 13:57
 * @Descripton :
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao dao;


	@Override
	public City findCityById(Long id) {
		return dao.findCityById(id);
	}

	@Override
	public Long saveCity(City city) {
		return null;
	}

	@Override
	public Long updateCity(City city) {
		return null;
	}

	@Override
	public Long deleteCity(Long id) {
		return null;
	}
}
