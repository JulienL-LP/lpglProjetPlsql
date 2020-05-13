package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.interfaces.IDepartVolDAO;
import lombok.NonNull;
import modele.DepartVol;

public class DatabaseDepartVolDAO implements IDepartVolDAO {

	private final static DatabaseDepartVolDAO instance = new DatabaseDepartVolDAO(Database.getInstance());

	@NonNull
	private final Database database;

	protected DatabaseDepartVolDAO(Database database)
	{
		this.database = database;
	}

	public static DatabaseDepartVolDAO getInstance()
	{
		return instance;
	}

	@Override
	public List<DepartVol> getList()
	{
		try (ResultSet res = database.getConnection().createStatement().executeQuery("SELECT * FROM DepartVol"))
		{
			List<DepartVol> list = new ArrayList<>();

			while (res.next())
			{
				list.add(new DepartVol(DatabaseVolDAO.getInstance().getById(res.getString("NoVol")),
						res.getDate("DateHeureDepart").toLocalDate(),
						res.getInt("DureeVol")));
			}

			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
