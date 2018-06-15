package com.energybot.weatherapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class WeatherService {
	
	private final WeatherRepository weatherRepository;
	
	public WeatherService(WeatherRepository weatherRepository) {
		this.weatherRepository=weatherRepository;
	}
	
	
	public List<Weather> showWeatherByStation(String Stationids){
		List<Weather> weathers = new ArrayList<Weather>();
		List<String> ids=Arrays.asList(Stationids.split(","));
		for(Weather weather : weatherRepository.findAll(ids) ) {
			System.out.println(weather);
			weathers.add(weather);
		}		
		return weathers;
	}
	
	}

	