package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.SignUpDao;
import dto.Employee;

public class GetByEmail extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String mail = req.getParameter("email");

		SignUpDao dao = new SignUpDao();
		Employee e = dao.findByEmail(mail);
		if (e != null) {
			res.getWriter().print("<table>" 
					+ "<tr>" 
					+ "    <th style='border: 2px solid black;'>id</th>"
					+ "    <th style='border: 2px solid black;'>name</th>"
					+ "    <th style='border: 2px solid black;'>age</th>"
					+ "    <th style='border: 2px solid black;'>email</th>"
					+ "    <th style='border: 2px solid black;'>password</th>"
					+"</tr>"
					+ "<tr>"
					+ "	   <td style='border: 2px solid black;'>"+e.getId()+"</td>"
					+ "	   <td style='border: 2px solid black;'>"+e.getName()+"</td>"
					+ "	   <td style='border: 2px solid black;'>"+e.getAge()+"</td>"
					+ "	   <td style='border: 2px solid black;'>"+e.getEmail()+"</td>"
					+ "	   <td style='border: 2px solid black;'>"+e.getPassword()+"</td>"
					+ "</tr>)"
					+"</table>");
		}

	}

}
