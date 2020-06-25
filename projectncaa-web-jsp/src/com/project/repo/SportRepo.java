package com.project.repo;

import com.project.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	

}
