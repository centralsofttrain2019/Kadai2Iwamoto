<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean
		id="bean"
		class="bean.DispEmployeeListBean"
		scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BeanStartWebApp</title>
</head>

<body>
従業員情報一覧<br>

<table>
	<tr bgcolor="#999999">
		<td> EmployeeID		&nbsp;</td>
		<td> EmployeeName	&nbsp;</td>
		<td> BloodType		&nbsp;</td>
		<td> E-Mail			&nbsp;</td>
		<td> HireFiscalYear	&nbsp;</td>
		<td> Birthday		&nbsp;</td>
		<td> Height			&nbsp;</td>
		<td> Weight			&nbsp;</td>
	</tr>

	<%
		int i=0;
		for( bean.EmployeeBean b: bean.getEmpList() ){
	%>
	<tr bgcolor = <%= i++ % 2 == 0 ? "#dddddd" : "#bbbbbb" %> >
		<td> <%= b.getEmployeeID() %>		&nbsp;</td>
		<td> <%= b.getEmployeeName() %>		&nbsp;</td>
		<td> <%= b.getBloodType() %>		&nbsp;</td>
		<td> <%= b.geteMail() %>			&nbsp;</td>
		<td> <%= b.getHireFiscalYear() %>	&nbsp;</td>
		<td> <%= b.getBirthday() %>			&nbsp;</td>
		<td> <%= b.getHeight() %>			&nbsp;</td>
		<td> <%= b.getWeight() %>			&nbsp;</td>
	</tr>
	<%}%>
</table>

</body>
</html>