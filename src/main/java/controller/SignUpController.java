package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.SignUpDao;
import dto.Employee;

public class SignUpController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name =req.getParameter("uname");
		String age = req.getParameter("age");
		int age1 = Integer.parseInt(age);
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee emp = new Employee();
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setAge(age1);
		emp.setName(name);
		
		SignUpDao sdao = new SignUpDao();
		
		if(sdao.saveDetails(emp)) {
			PrintWriter out = res.getWriter();
			out.print("<h1>Details Added SucessFully<h1>");
		}
		
		
		
	}

	
}
