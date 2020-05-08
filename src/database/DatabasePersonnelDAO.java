package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.interfaces.IPersonnelDAO;
import lombok.NonNull;
import modele.Personnel;

public class DatabasePersonnelDAO implements IPersonnelDAO {

	private final static DatabasePersonnelDAO instance = new DatabasePersonnelDAO(Database.getInstance());

	@NonNull
	private final Database database;

	protected DatabasePersonnelDAO(Database database)
	{
		this.database = database;
	}

	public static DatabasePersonnelDAO getInstance()
	{
		return instance;
	}

	@Override
	public List<Personnel> getList()
	{
		try (ResultSet res = database.getConnection().createStatement().executeQuery("SELECT * FROM Vol"))
		{
			List<Personnel> list = new ArrayList<>();

			while (res.next())
				list.add(new Personnel(res.getInt("Matricule"), res.getString("Nom"), res.getString("Categorie"), res.getString("Fonction")));

			return list;

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
