package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL , JDBCConstants.USER , JDBCConstants.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute(SQLQueries.CREATE_TABLE);
//            statement.execute(SQLQueries.INSERT_USERS);
            System.out.println("All users:");
            var resultSet = statement.executeQuery(SQLQueries.SELECT_ALL_USERS);
            var users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                users.add(user);
            }
            users.forEach(System.out::println);
            System.out.println("");

            System.out.println("Users younger than 18:");
            var resultSetYounger18 = statement.executeQuery(SQLQueries.SELECT_USERS_YOUNGER_THAN_18);
            var usersYounger18 = new ArrayList<>();
            while (resultSetYounger18.next()) {
                User user = new User();
                user.setId(resultSetYounger18.getInt("id"));
                user.setFirstName(resultSetYounger18.getString("first_name"));
                user.setLastName(resultSetYounger18.getString("last_name"));
                user.setAge(resultSetYounger18.getInt("age"));
                user.setGender(resultSetYounger18.getString("gender"));
                usersYounger18.add(user);
            }
            usersYounger18.forEach(System.out::println);
            System.out.println("");

            System.out.println("Users whose name ends with 'o' :");
            var resultSetNameEndsWithO = statement.executeQuery(SQLQueries.SELECT_USERS_WHOSE_NAME_ENDS_WITH_O);
            var usersNameEndsWithO = new ArrayList<>();
            while (resultSetNameEndsWithO.next()) {
                User user = new User();
                user.setId(resultSetNameEndsWithO.getInt("id"));
                user.setFirstName(resultSetNameEndsWithO.getString("first_name"));
                user.setLastName(resultSetNameEndsWithO.getString("last_name"));
                user.setAge(resultSetNameEndsWithO.getInt("age"));
                user.setGender(resultSetNameEndsWithO.getString("gender"));
                usersNameEndsWithO.add(user);
            }
            usersNameEndsWithO.forEach(System.out::println);
            System.out.println("");

            System.out.println("Users from 18 to 60 :");
            var resultSetUsersFrom18To60 = statement.executeQuery(SQLQueries.SELECT_USERS_WHOSE_AGE_HIGHER_THAN_18_BUT_LESS_THAN_60);
            var usersFrom18To60 = new ArrayList<>();
            while (resultSetUsersFrom18To60.next()) {
                User user = new User();
                user.setId(resultSetUsersFrom18To60.getInt("id"));
                user.setFirstName(resultSetUsersFrom18To60.getString("first_name"));
                user.setLastName(resultSetUsersFrom18To60.getString("last_name"));
                user.setAge(resultSetUsersFrom18To60.getInt("age"));
                user.setGender(resultSetUsersFrom18To60.getString("gender"));
                usersFrom18To60.add(user);
            }
            usersFrom18To60.forEach(System.out::println);
            System.out.println("");

            var resulSetCount = statement.executeQuery(SQLQueries.COUNT_NUMBER_OF_USERS_WITH_A_IN_FIRST_NAME);
            resulSetCount.next();
            int count = resulSetCount.getInt("rawcount");
            resulSetCount.close();
            System.out.println("Number of users with 'a' in first name : " + count);
            System.out.println("");

            var resulSetCountUsersAbove18 = statement.executeQuery(SQLQueries.COUNT_NUMBER_OF_USERS_ABOVE_18);
            resulSetCountUsersAbove18.next();
            int countUsersAbove18 = resulSetCountUsersAbove18.getInt("rawcount");
            resulSetCountUsersAbove18.close();
            System.out.println("Number of users above 18 : " + countUsersAbove18);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
