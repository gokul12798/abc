package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public Country getCountryUS() {

		LOGGER.info("Start");
		
		Country country = applicationContext.getBean("us", Country.class);

		LOGGER.info("End");
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("Start");

		ArrayList<Country> countries = applicationContext.getBean("countryList", ArrayList.class);

		LOGGER.info("End");
		return countries;
	}

	@GetMapping("/country/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		LOGGER.info("Start");

		ArrayList<Country> countries = applicationContext.getBean("countryList", ArrayList.class);
		
		Country country = countryService.getCountry(code);
		
		LOGGER.info("End");
		return country;
	}
	
	@PostMapping("/countries")
	public void addCountry(@Valid @RequestBody Country country) {
		LOGGER.info("Start");
		
		LOGGER.debug("Added {}", country);
		
		LOGGER.info("End");
	}
}
