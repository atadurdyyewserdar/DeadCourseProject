package javaapplication5.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DatabaseConnection {

    private Connection connection;

    public Connection getconnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/abcde" + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";
        connection = DriverManager.getConnection(connectionString, "root", "root123");
        return connection;
    }
}
