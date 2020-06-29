package com.project.model;


public class Sport {
	
		String name;
		int sportId;
		int seasonId;
		int schoolId;
		
		
		public Sport(){
			
		}
		
		
		public Sport(int sportId, String name, int seasonId, int schoolId) {
			super();
			this.sportId = sportId;
			this.name = name;
			this.seasonId = seasonId;
			this.schoolId = schoolId;
		}


		public int getSportId() {
			return sportId;
		}


		public void setSportId(int sportId) {
			this.sportId = sportId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getSeasonId() {
			return seasonId;
		}


		public void setSeasonId(int seasonId) {
			this.seasonId = seasonId;
		}


		public int getSchoolId() {
			return schoolId;
		}


		public void setSchoolId(int schoolId) {
			this.schoolId = schoolId;
		}
		
		@Override
		public String toString(){
			return sportId + "," + name + "," + schoolId + "," + seasonId; 
			
		}

	}


