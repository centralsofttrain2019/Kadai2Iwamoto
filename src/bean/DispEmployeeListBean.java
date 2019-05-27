package bean;

import java.util.List;

public class DispEmployeeListBean
{
	private List<EmployeeBean> empList;

	public List<EmployeeBean> getEmpList()
	{
		return empList;
	}
	public void setEmpList(List<EmployeeBean> empList)
	{
		this.empList = empList;
	}

	@Override
	public String toString()
	{
		return "EmployeeListDispBean [empList=" + empList + "]";
	}
}
