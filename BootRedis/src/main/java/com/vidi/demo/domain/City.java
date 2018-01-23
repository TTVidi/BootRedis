package com.vidi.demo.domain;

import java.io.Serializable;

/**
 * @Author : Vidi
 * @Date : 2018/1/2 11:41
 * @Descripton : This is a city domain
 */
public class City implements Serializable {
	private static final long serialVersionUID = -1L;

	/**
	 * City Code
	 */
	private Long id;

	/**
	 * Province Code
	 */
	private Long provinceId;

	/**
	 * City Name
	 */
	private String cityName;

	/**
	 * Description
	 */
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", provinceId=" + provinceId +
				", cityName='" + cityName + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
