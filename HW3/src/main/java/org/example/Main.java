package org.example;

public class Main {
    public static void main(String[] args) {
        TableServices tableServices = new TableServices();
        tableServices.showAllUsers();
        tableServices.showUsersYounger18();
        tableServices.showUsersWhoseNameEndsWithO();
        tableServices.showUsersFrom18To60();
        tableServices.showNumberOfUsersWithAInName();
        tableServices.showNumberOfUsersAbove18();
    }
}
