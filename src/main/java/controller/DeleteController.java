package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import dao.SignUpDao;
import dto.Employee;

public class DeleteController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String mail = req.getParameter("email");
		String password = req.getParameter("password");

		SignUpDao dao = new SignUpDao();

		if (dao.deleteByEmail(mail)) {
			PrintWriter out = res.getWriter();
			out.print("<h1>Record deleted sucessfully<h1>");
		} else {
			PrintWriter out = res.getWriter();
			out.print("under construction");
		}

	}

}
