package com.energybot.weatherapi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/welcome")
	public String Hello(HttpServletRequest request) {
		request.setAttribute("mode", "ALL_USERS");
		return "WeatherApi";
	}
	
	@GetMapping("/home")
	public String showWeatherByStation(@RequestParam(name="Stationid") String Stationid,HttpServletRequest request) {
		request.setAttribute("mode", "ALL_USERS");
		request.setAttribute("weathers", weatherService.showWeatherByStation(Stationid));
		return "WeatherApi";
	}
}
