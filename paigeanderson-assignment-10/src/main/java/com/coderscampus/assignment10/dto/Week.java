package com.coderscampus.assignment10.dto;

public class Week {
	
	private DayResponse monday;
	private DayResponse tuesday;
	private DayResponse wednesday;
	private DayResponse thursday;
	private DayResponse friday;
	private DayResponse saturday;
	private DayResponse Sunday;
	
	public DayResponse getMonday() {
		return monday;
	}
	public void setMonday(DayResponse monday) {
		this.monday = monday;
	}
	public DayResponse getTuesday() {
		return tuesday;
	}
	public void setTuesday(DayResponse tuesday) {
		this.tuesday = tuesday;
	}
	public DayResponse getWednesday() {
		return wednesday;
	}
	public void setWednesday(DayResponse wednesday) {
		this.wednesday = wednesday;
	}
	public DayResponse getThursday() {
		return thursday;
	}
	public void setThursday(DayResponse thursday) {
		this.thursday = thursday;
	}
	public DayResponse getFriday() {
		return friday;
	}
	public void setFriday(DayResponse friday) {
		this.friday = friday;
	}
	public DayResponse getSaturday() {
		return saturday;
	}
	public void setSaturday(DayResponse saturday) {
		this.saturday = saturday;
	}
	public DayResponse getSunday() {
		return Sunday;
	}
	public void setSunday(DayResponse sunday) {
		Sunday = sunday;
	}
	
	@Override
	public String toString() {
		return "Week [monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday
				+ ", friday=" + friday + ", saturday=" + saturday + ", Sunday=" + Sunday + "]";
	}
	
	

}
