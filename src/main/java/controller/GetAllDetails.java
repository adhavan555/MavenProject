package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.SignUpDao;
import dto.Employee;

public class GetAllDetails extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		SignUpDao dao = new SignUpDao();
		
		List li = dao.getAllDetails();
		
		String html = "<table  style=\"border-collapse: collapse;\">\r\n"
				+ "<tr>\r\n"
				+ "    <th style='border: 2px solid black;'>id</th>\r\n"
				+ "    <th style='border: 2px solid black;'>name</th>\r\n"
				+ "    <th style='border: 2px solid black;'>age</th>\r\n"
				+ "    <th style='border: 2px solid black;'>email</th>\r\n"
				+ "    <th style='border: 2px solid black;'>password</th>\r\n"
				+ "</tr>\r\n";
		
		for (Object object : li) {
//			res.getWriter().print("<h1>"+object+"</h1>");
			
			Employee e = (Employee)object;
			html +="<tr>\r\n"
					+ "    <td style=\"border: 2px solid black;\">"+e.getId()+"</td>\r\n"
					+ "    <td style=\"border: 2px solid black;\">"+e.getName()+"</td>\r\n"
					+ "    <td style=\"border: 2px solid black;\">"+e.getAge()+"</td>\r\n"
					+ "    <td style=\"border: 2px solid black;\">"+e.getEmail()+"</td>\r\n"
					+ "    <td style=\"border: 2px solid black;\">"+e.getPassword()+"</td>\r\n"
					+ "</tr>\r\n";
		}
		
		
		
		html = html +"</table>";
		
		res.getWriter().print(html);
	}

	
}
