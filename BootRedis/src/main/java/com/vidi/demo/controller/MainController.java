package com.vidi.demo.controller;

import com.vidi.demo.domain.City;
import com.vidi.demo.service.CityService;
import com.vidi.demo.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author : Vidi
 * @Date : 2018/1/2 15:44
 * @Descripton :  MainController  redirect to other page
 * <p>
 * Default find the certain file in src/resources/templates/XX.html
 */
@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityService service;


	@Autowired
	private RedisUtils<String> redisUtils;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/hello")
	public String index(Model model) {
		model.addAttribute("name", "Vidi");
		return "hello";
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "id", defaultValue = "2") Long id, Model model) {
		Long before = System.currentTimeMillis();
		City city = redisUtils.get(id + "");
		if(city==null){
			city = service.findCityById(id);
			if(city!=null){
				logger.info("get City Message from DataBase");
				redisUtils.set(id + "",city);
			}
		}else{
			logger.info("get City Message from Redis");
		}
		model.addAttribute("name", city == null ? "VV" : city.getCityName() + "");
		logger.info("Time : "+((System.currentTimeMillis() - before)));
		return "hello";
	}

	@RequestMapping("/redis")
	public String redis(@RequestParam(value = "id", defaultValue = "2") Long id, Model model) {
		boolean result = redisUtils.set(id + "", "长沙");
		model.addAttribute("name", "false");
		if (result) {
			model.addAttribute("name", "true");
		}
		return "hello";
	}
}
