package dao;

import java.sql.*;

public class JDBCUtils {

    public static Connection getCon() throws ClassNotFoundException {
        Class.forName(JDBCConstants.DRIVER);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER_NAME, JDBCConstants.USER_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
