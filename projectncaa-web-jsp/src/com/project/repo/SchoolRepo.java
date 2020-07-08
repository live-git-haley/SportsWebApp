package com.project.repo;

import com.project.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SchoolRepo {
	
	public List<School> getSchools() {
		List<School> schoolList = new ArrayList<School>();
		

		try {
			GetConnection connection = new GetConnection();
			Connection connect = connection.getConnection();
			Statement statement = connect.createStatement();

			ResultSet resultSet =statement.executeQuery("select * from school;");

			while (resultSet.next()) {
				School school = new School();
				school.setName(resultSet.getString("name"));
				school.setSchoolID(resultSet.getInt("schoolid"));
				school.setCity(resultSet.getString("city"));
				school.setState(resultSet.getString("state"));

				schoolList.add(school);
			}
			resultSet.close();
			connect.close();
			statement.close();

			return (schoolList);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return (null);
	}

}
