package com.energybot.weatherapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Weather, Weather> {

    private static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public Weather process(final Weather weather) throws Exception {
        final String Stationid = weather.getStationid();
        final String yearmonth = weather.getYearmonth();

        final Weather transformedweather = new Weather(Stationid, yearmonth,weather.getElement(),weather.getValue1(),weather.getMflag1(),weather.getQflag1(),weather.getSflag1(),weather.getValue2());

        //log.info("Converting (" + weather + ") into (" + transformedweather + ")");

        return transformedweather;
    }

}
