package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.interfaces.IVolDAO;
import lombok.NonNull;
import modele.Vol;

public class DatabaseVolDAO implements IVolDAO {

	private final static DatabaseVolDAO instance = new DatabaseVolDAO(Database.getInstance());

	@NonNull
	private final Database database;

	protected DatabaseVolDAO(Database database)
	{
		this.database = database;
	}

	public static DatabaseVolDAO getInstance()
	{
		return instance;
	}

	@Override
	public List<Vol> getList()
	{
		try (ResultSet res = database.getConnection().createStatement().executeQuery("SELECT * FROM Vol"))
		{
			List<Vol> list = new ArrayList<>();

			while (res.next())
				list.add(new Vol(res.getString("NoVol"), res.getString("Depart"), res.getString("Arrivee")));

			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Vol getById(String pk)
	{
		try (PreparedStatement req = database.getConnection().prepareStatement("SELECT * FROM Vol WHERE NoVol = ?"))
		{
			req.setString(1, pk);

			ResultSet res = req.executeQuery();

			if (res.next())
				return new Vol(pk, res.getString("Depart"), res.getString("Arrivee"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
