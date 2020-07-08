package com.project.repo;

import com.project.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SportRepo {

	public Sport getFirstSport() {
		Sport sport = new Sport();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
					"haleykobe2");
			System.out.println("Connected!");

			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			System.out.println("Created the sport: ");
			ResultSet resultSet = statement.executeQuery("select * from sport where sportid = 4;");

			while (resultSet.next()) {
				sport.setSportId(resultSet.getInt("sportid"));
				sport.setName(resultSet.getString("name"));
				sport.setSchoolId(resultSet.getInt("schoolid"));
				sport.setSeasonId(resultSet.getInt("seasonid"));

			}
			resultSet.close();
			statement.close();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

		return (sport);
	}

	public List<Sport> getSports() {
		List<Sport> sportList = new ArrayList<Sport>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
					"haleykobe2");
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

			return (sportList);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

		return (null);
	}

	public boolean saveSport(Sport sport) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
					"haleykobe2");
			System.out.println("Connected!");

			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			System.out.println("Creating the sport ");
			statement.execute("insert into sport (name, schoolid, seasonid) values ('"  + sport.getName() + "', "
					+ sport.getSchoolId() + "," + sport.getSeasonId() + ");");

			statement.close();

			System.out.println("You saved this sport!!");
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return false;

	}

	public void deleteSport(int sportid) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root",
					"haleykobe2");
			System.out.println("Connected!");

			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			System.out.println("deleting the sport");
			int i = statement.executeUpdate("delete from sport where sportid = " + sportid + ";");

			statement.close();
			System.out.println("You deleted the sport using the repo layer.");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}
	public List<Season> getSeasons() {
		List<Season> seasonList = new ArrayList<Season>();
		

		try {
			GetConnection connection = new GetConnection();
			Connection connect = connection.getConnection();
			Statement statement = connect.createStatement();

			ResultSet resultSet =statement.executeQuery("select * from season;");

			while (resultSet.next()) {
				Season season = new Season();
				season.setSeasonID(resultSet.getInt("seasonID"));
				season.setName(resultSet.getString("name"));

				seasonList.add(season);
			}
			resultSet.close();
			connect.close();
			statement.close();

			return (seasonList);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return (null);
	}

	
}
