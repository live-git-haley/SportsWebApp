package com.project.repo;

import com.project.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Sport;



public class SportRepo {
	
public Sport getFirstSport() {
	Sport sport = new Sport();
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "haleykobe2");
		System.out.println("Connected!");
		
		Statement statement = connection.createStatement();
		System.out.println("Statement created!");
		// Fetch the results by executing the query
		System.out.println("Created the sport: ");
		ResultSet resultSet = statement.executeQuery("select * from sport;");
		
	
		 while (resultSet.next()) { 
			sport.setSportId(resultSet.getInt("sportid"));
			sport.setName(resultSet.getString("name")); 
			sport.setSchoolId(resultSet.getInt("schoolid"));
			sport.setSeasonId(resultSet.getInt("sportid"));

		 }
		resultSet.close();
		statement.close();

}
	catch(SQLException  | ClassNotFoundException e ) {
		System.out.println(e);
	}
	
	return(sport);
}


public List<Sport> getSports() {
	List<Sport> sportList = new ArrayList<Sport>();
	
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "haleykobe2");
		System.out.println("Connected!");
		
		Statement statement = connection.createStatement();
		System.out.println("Statement created!");
		// Fetch the results by executing the query
		System.out.println("Creating the sport List: ");
		ResultSet resultSet = statement.executeQuery("select * from sport;");
		
	
		 while (resultSet.next()) { 
			Sport sport = new Sport();
			sport.setSportId(resultSet.getInt("sportid"));
			sport.setName(resultSet.getString("name")); 
			sport.setSchoolId(resultSet.getInt("schoolid"));
			sport.setSeasonId(resultSet.getInt("sportid"));
			sportList.add(sport);
		 }
		resultSet.close();
		statement.close();
		
		return(sportList);
}
	catch(SQLException  | ClassNotFoundException e ) {
		System.out.println(e);
	}
	
	return(null);
}

public boolean saveSport(Sport sport) {
	
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "haleykobe2");
		System.out.println("Connected!");
		
		Statement statement = connection.createStatement();
		System.out.println("Statement created!");
		// Fetch the results by executing the query
		System.out.println("Creating the sport List: ");
		ResultSet resultSet = statement.executeQuery("insert into sport values (" + sport.getSportId() + ", '" + sport.getName()
				+ "', " + sport.getSchoolId() + "," + sport.getSeasonId());
		
	
		
		resultSet.close();
		statement.close();
		
		System.out.println("You saved this sport!!");
		return true;
}
	catch(SQLException  | ClassNotFoundException e ) {
		System.out.println(e);
	}
	return false;
	
}
	
	
	
	
	

}
