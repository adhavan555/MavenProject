package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.SignUpDao;
import dto.Employee;

public class LoginController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String mail = req.getParameter("mail");
		String password = req.getParameter("password");

		SignUpDao dao = new SignUpDao();

		Employee e = dao.findByEmail(mail);

		if (e.getEmail().equals(mail)) {
			if (e.getPassword().equals(password)) {
				String html = "<!DOCTYPE html>" + "<html lang=\"en\">" + "<head>" + "    <meta charset=\"UTF-8\">"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
						+ "    <title>Restaurant</title>" + "    <link rel=\"stylesheet\" href=\"index.css\">"
						+ "</head>" + "<body>" + "<table style='border: 2px solid red;'>"
						+ "<tr style='border: 2px solid red;'>" + "    <th>id</th>" + "    <th>name</th>"
						+ "    <th>age</th>" + "    <th>email</th>" + "    <th>password</th>" + "</tr>"
						+ "<tr style='border: 2px solid red;'>" + "    <td>" + e.getId() + "</td>" + "    <td>"
						+ e.getName() + "</td>" + "    <td>" + e.getAge() + "</td>" + "    <td>" + e.getEmail()
						+ "</td>" + "    <td>" + e.getPassword() + "</td>" + "</tr>" + "" + "</table>"
						+ "    <a href=\"GetByEmail.html\">getbymail</a><br>"
						+ "    <a href=\"DeleteByEmail.html\">deletebymail</a><br>"
						+ "    <a href='getalldetails'>getalldetails</a>" + "</body>" + "</html>";
				PrintWriter out = res.getWriter();
				out.print(html);

			} else {
				PrintWriter out = res.getWriter();
				out.print("<h1>Wrong Password<h1>");
			}
		} else {
			PrintWriter out = res.getWriter();
			out.print("<h1>Wrong email<h1>");
		}

	}

}
