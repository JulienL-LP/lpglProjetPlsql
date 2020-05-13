package database;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import lombok.NonNull;
import modele.DepartVol;
import modele.Personnel;

public class SQL {

	private final static SQL instance = new SQL(Database.getInstance());

	@NonNull
	private final Database database;

	protected SQL(Database database)
	{
		this.database = database;
	}

	public static SQL getInstance()
	{
		return instance;
	}

	// Programmer(noVol in varchar2, DateHeureDep in date, DV in number)
	public void programmer(DepartVol departVol)
	{
		try (PreparedStatement req = database.getConnection().prepareCall("{call Programmer(?, ?, ?)}"))
		{
			req.setString(1, departVol.getVol().getNoVol());
			req.setDate(2, Date.valueOf(departVol.getDateDepart()));
			req.setInt(3, departVol.getDureeVol());

			req.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	// AffecterPersonnel(noVol in varchar2, DateHeureDep in date, Mat in number)
	public void affecterPersonnel(DepartVol departVol, Personnel personnel)
	{
		try (PreparedStatement req = database.getConnection().prepareCall("{call AffecterPersonnel(?, ?, ?)}"))
		{
			req.setString(1, departVol.getVol().getNoVol());
			req.setDate(2, Date.valueOf(departVol.getDateDepart()));
			req.setInt(3, personnel.getMatricule());

			req.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	// MAJDuree(noVol in varchar2, DateHeureDep in date, DV in number)
	public void majDuree(DepartVol departVol)
	{
		try (PreparedStatement req = database.getConnection().prepareCall("{call MAJDuree(?, ?, ?)}"))
		{
			req.setString(1, departVol.getVol().getNoVol());
			req.setDate(2, Date.valueOf(departVol.getDateDepart()));
			req.setInt(3, departVol.getDureeVol());

			req.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	// MembresEquipage(noVol in varchar2, DateHeureDep in date)
	public List<String> membresEquipage(DepartVol departVol)
	{
		List<String> list = new ArrayList<>();

		try
		(
			Statement s = database.getConnection().createStatement();
			CallableStatement req = database.getConnection().prepareCall("{call MembresEquipage(?, ?)}");
			CallableStatement reqDBMS = database.getConnection().prepareCall(
					"declare num integer := 1000;"
					+ "begin dbms_output.get_lines(?, num); end;")
		)
		{
			s.executeUpdate("begin dbms_output.enable(); end;");

			req.setString(1, departVol.getVol().getNoVol());
			req.setDate(2, Date.valueOf(departVol.getDateDepart()));

			req.execute();

			reqDBMS.registerOutParameter(1, Types.ARRAY, "DBMSOUTPUT_LINESARRAY");

			reqDBMS.execute();

			Array array = null;

			try
			{
				array = reqDBMS.getArray(1);
				Stream.of((Object[]) array.getArray()).forEach(o -> {
					if (o != null)
						list.add(o.toString());
				});
			}
			finally
			{
				if (array != null)
					array.free();
			}

			s.executeUpdate("begin dbms_output.disable(); end;");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return list;
	}
}
