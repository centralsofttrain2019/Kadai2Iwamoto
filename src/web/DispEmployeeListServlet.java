package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DispEmployeeListBean;
import service.GetEmployeesService;

/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/EmployeeListServlet")
public class DispEmployeeListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispEmployeeListServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//サービスを取得
		GetEmployeesService service = new GetEmployeesService();
		DispEmployeeListBean bean = service.findAll();

		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/dispEmployeeList.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
