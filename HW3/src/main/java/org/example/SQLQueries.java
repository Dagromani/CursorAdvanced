package org.example;

public final class SQLQueries {

    public static final String CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS users(
        id int PRIMARY KEY AUTO_INCREMENT,
        first_name varchar(50),
        last_name varchar(50),
        age int,
        gender varchar(50))
        """;

    public static final String INSERT_USERS = """
            INSERT INTO `users` (`first_name`, `last_name`, `age` , `gender`) VALUES 
            ('Nikolai', 'Kozliar', '23' , 'Male'),
            ('Nikita', 'Makarevich', '12' , 'Male'),
            ('Eva', 'Oborina', '66', 'Female'),
            ('Lesha', 'Korchmar', '40', 'Male'),
            ('Arsen', 'Oganesyan', '55', 'Male'),
            ('Nestor', 'Wise', '80' , 'Male'),
            ('Sveta', 'Vesna', '25' , 'Female'),
            ('Sasha', 'Beloval', '23' , 'Female');           
            """;

    public static final String SELECT_ALL_USERS = """
        SELECT * FROM users
        """;

    public static final String SELECT_USERS_YOUNGER_THAN_18 = """
            SELECT * FROM users WHERE age < 18
            """;

    public static final String SELECT_USERS_WHOSE_NAME_ENDS_WITH_O = """
            SELECT * FROM users WHERE first_name LIKE '%o'
            """;

    public static final String SELECT_USERS_WHOSE_AGE_HIGHER_THAN_18_BUT_LESS_THAN_60 = """
            SELECT * FROM users WHERE age BETWEEN 18 and 60
            """;

    public static final String COUNT_NUMBER_OF_USERS_WITH_A_IN_FIRST_NAME = """
            SELECT COUNT(*) AS rawcount FROM users WHERE first_name LIKE '%a%' or 'a%' or '%a' 
            """;

    public static final String COUNT_NUMBER_OF_USERS_ABOVE_18 = """
            SELECT COUNT(*) AS rawcount FROM users WHERE age >= 18
            """;
}
