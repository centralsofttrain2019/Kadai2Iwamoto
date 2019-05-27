package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.DispEmployeeListBean;
import bean.EmployeeBean;
import dao.Dao;
import dao.EmployeesDao;

public class GetEmployeesService
{
	public EmployeeBean findByKey(String strId)
	{

		EmployeeBean emp = null;
		try( Connection con = Dao.getConnection() )
		{
			int id= Integer.parseInt( strId );
			EmployeesDao dao = new EmployeesDao(con);
			emp =  dao.findByKey(id);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return emp;
	}


	public DispEmployeeListBean findAll()
	{
		DispEmployeeListBean bean = new DispEmployeeListBean();

		try( Connection con= Dao.getConnection() )
		{
			EmployeesDao dao = new EmployeesDao(con);
			List<EmployeeBean> eList = dao.findAll();
			bean.setEmpList(eList);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

}
