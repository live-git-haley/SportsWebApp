package com.project.model;

public class School {

	int schoolID;
	String name;
	String city;
	String state;

	public School() {

	}

	public School(String name, String city, String state) {
		this.name = name;
		this.city = city;
		this.state = state;
	}

	public int getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return schoolID + "," + name + "," + city + "," + state;
	}
}
