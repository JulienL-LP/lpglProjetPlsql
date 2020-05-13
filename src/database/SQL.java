package database;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
		try (PreparedStatement req = database.getConnection().prepareCall("execute Programmer(?, ?, ?)"))
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
		try (PreparedStatement req = database.getConnection().prepareCall("execute AffecterPersonnel(?, ?, ?)"))
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
		try (PreparedStatement req = database.getConnection().prepareCall("execute MAJDuree(?, ?, ?)"))
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
	public void membresEquipage(DepartVol departVol)
	{
		try (Statement s = database.getConnection().createStatement();
			CallableStatement req = database.getConnection().prepareCall("execute MembresEquipage(?, ?)"))
		{
			s.executeUpdate("begin dbms_output.enable(); end;");

			req.registerOutParameter(1, Types.ARRAY, "DBMSOUTPUT_LINESARRAY");

			req.setString(1, departVol.getVol().getNoVol());
			req.setDate(2, Date.valueOf(departVol.getDateDepart()));

			req.execute();

			Array array = null;

			try
			{
				array = req.getArray(1);
				Stream.of((Object[]) array.getArray()).forEach(System.out::println);
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
	}
}
