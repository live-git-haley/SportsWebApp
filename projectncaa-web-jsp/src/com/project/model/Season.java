package com.project.model;

public class Season {
	int seasonID;
	String name;
	
	public Season(){
		
	}
	
	public Season(int seasonID, String name){
		this.seasonID = seasonID;
		this.name = name;
	}

	public int getSeasonID() {
		return seasonID;
	}

	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}