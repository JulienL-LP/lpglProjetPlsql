package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

	private static Database database = new Database();

	private String databaseChoice;
	private String url;
	private String port;
	private String user;
	private String password;

	private Connection connection;

	private Database()
	{
		try (InputStream inputFile = getClass().getClassLoader().getResourceAsStream("databaseConfig.properties"))
		{
			if (inputFile == null)
				throw new IOException("Fichier indisponible");

			Properties databaseConfig = new Properties();

			databaseConfig.load(inputFile);

			this.databaseChoice = databaseConfig.getProperty("db.database");
			this.url = databaseConfig.getProperty("db.url", "localhost");
			this.port = databaseConfig.getProperty("db.port", "3306");
			this.user = databaseConfig.getProperty("db.user", "root");
			this.password = databaseConfig.getProperty("db.password", "");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	private void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:" + databaseChoice + ":thin:@" + url + ":" + port + ":XE", user, password);
		}
		catch (Exception e)
		{}
	}

	public static Database getInstance()
	{
		if (!database.isConnected())
			database.connect();
		return database;
	}

	public static void closeConnection()
	{
		try
		{
			if (database.isConnected())
			{
				database.connection.close();
				database.connection = null;
			}
		}
		catch (SQLException e)
		{}
	}

	public boolean isConnected()
	{
		try
		{
			return connection != null && !connection.isClosed();
		}
		catch (SQLException e)
		{
			return false;
		}
	}

	public Connection getConnection()
	{
		return connection;
	}
}
