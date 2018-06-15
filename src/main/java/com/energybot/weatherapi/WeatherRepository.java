package com.energybot.weatherapi;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface WeatherRepository extends CrudRepository<Weather, String> {


}