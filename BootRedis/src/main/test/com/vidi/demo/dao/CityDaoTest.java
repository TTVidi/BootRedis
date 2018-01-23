package com.vidi.demo.dao;


import com.vidi.demo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author : Vidi
 * @Date : 2018/1/2 14:36
 * @Descripton :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CityDaoTest {

	@Autowired
	CityDao dao;

	@Test
	public void findAllCity() throws Exception {
		System.out.println(dao.findAllCity().size());
	}

	@Test
	public void findCityById() throws Exception {
	}

	@Test
	public void saveCity() throws Exception {
	}

	@Test
	public void updateCity() throws Exception {
	}

	@Test
	public void deleteCity() throws Exception {
	}

}
