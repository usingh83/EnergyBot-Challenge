package com.energybot.weatherapi;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Weather")
public class Weather implements Serializable{

	private static final long serialVersionUID = -6402068923614583448L;
	
	private Integer id;
	@Id
	private String Stationid;
    private String yearmonth;
    private String element;
	private Integer value1;
    private String mflag1;
    private String qflag1;
    private String sflag1;
    private Integer value2;
    

    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStationid() {
		return Stationid;
	}


	public void setStationid(String stationid) {
		Stationid = stationid;
	}


	public String getYearmonth() {
		return yearmonth;
	}


	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}


	public String getElement() {
		return element;
	}


	public void setElement(String element) {
		this.element = element;
	}


	public Integer getValue1() {
		return value1;
	}


	public void setValue1(Integer value1) {
		this.value1 = value1;
	}


	public String getMflag1() {
		return mflag1;
	}


	public void setMflag1(String mflag1) {
		this.mflag1 = mflag1;
	}


	public String getQflag1() {
		return qflag1;
	}


	public void setQflag1(String qflag1) {
		this.qflag1 = qflag1;
	}


	public String getSflag1() {
		return sflag1;
	}


	public void setSflag1(String sflag1) {
		this.sflag1 = sflag1;
	}


	public Integer getValue2() {
		return value2;
	}


	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

    public Weather() {
    	
	}


	public Weather(String Stationid,String yearmonth,String element,Integer value1,String mflag1,String qflag1,String sflag1,Integer value2) {
		super();
		this.Stationid = Stationid;
		this.yearmonth = yearmonth;
		this.element = element;
		this.value1 = value1;
		this.mflag1 = mflag1;
		this.qflag1 = qflag1;
		this.sflag1 = sflag1;
		this.value2 = value2;
	}
	

	@Override
	public String toString() {
		return "Weather [id=" + id + ", Stationid=" + Stationid + ", yearmonth=" + yearmonth + ", element=" + element
				+ ", value1=" + value1 + ", mflag1=" + mflag1 + ", qflag1=" + qflag1 + ", sflag1=" + sflag1
				+ ", value2=" + value2 + "]";
	}


}
