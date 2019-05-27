package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeBean;

public class EmployeesDao
{
	private Connection con;

	private static final String DELETE_SQL =
			"DELETE "
			+ "FROM employees " +
			"WHERE "
			+ "EmployeeID = ?";

	private static final String FIND_BY_KEY_SQL =
			"SELECT * "
			+	"FROM "
			+ "		`sqat_schema`.`employees`"
			+ "WHERE "
			+ "	EmployeeID = ?";

	private static final String FIND_ALL_SQL =
			"SELECT * FROM Employees";


	public EmployeesDao(Connection con)
	{
		super();
		this.con = con;
	}

	public void deleteEmployee( int id ) throws SQLException
	{
		// 送信すべきSQLの雛形を作成
		try(PreparedStatement stmt = con.prepareStatement( DELETE_SQL ))
		{
			stmt.setInt( 1, id );
			int r = stmt.executeUpdate();

			if( r!=1 )
				throw new RuntimeException("削除に失敗しました。");
		}
	}


	public EmployeeBean findByKey(int id) throws SQLException
	{
		EmployeeBean ret = new EmployeeBean();

		PreparedStatement stmt = null;

		try
		{
			stmt = con.prepareStatement( FIND_BY_KEY_SQL );
			stmt.setInt( 1, id );
			ResultSet rs= stmt.executeQuery();

			while( rs.next() )
			{
				//ret.setEmployeeID( rs.getInt( "EmployeeID" ) );

				int eid  = rs.getInt( "EmployeeID" );
				ret.setEmployeeID( eid );

				ret.setEmployeeName( rs.getString("employeeName") );
				ret.setHeight( rs.getBigDecimal("height") );
				ret.seteMail( rs.getString("eMail") );
				ret.setWeight( rs.getBigDecimal("weight") );
				ret.setHireFiscalYear( rs.getInt("hireFiscalYear") );
				ret.setBirthday( rs.getDate("birthday").toLocalDate() );
				ret.setBloodType( rs.getString( "bloodType") );
			}
		}
		finally
		{
			if( stmt != null )
				stmt.close();
		}

		return ret;
	}


	public List<EmployeeBean> findAll() throws SQLException
	{
		List<EmployeeBean> eList = new ArrayList<EmployeeBean>();

		PreparedStatement stmt = con.prepareStatement(FIND_ALL_SQL);

		ResultSet rs = stmt.executeQuery();

		while(rs.next())
		{
			EmployeeBean ret = new EmployeeBean();
			ret.setEmployeeID(rs.getInt("EmployeeID"));
			ret.setEmployeeName(rs.getString("EmployeeName"));
			ret.seteMail(rs.getString("Email"));
			ret.setWeight(rs.getBigDecimal("Weight"));
			ret.setHeight(rs.getBigDecimal("Height"));
			ret.setBirthday(rs.getDate("Birthday").toLocalDate());
			ret.setBloodType(rs.getString("BloodType"));
			ret.setHireFiscalYear(rs.getInt("HireFiscalYear"));
			eList.add(ret);
		}

		return eList;
	}
}
