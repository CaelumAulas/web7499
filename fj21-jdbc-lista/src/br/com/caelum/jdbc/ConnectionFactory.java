package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "root");
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
