package com.tap.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import com.tap.employee;
import com.tap.bo.employeeboimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Register extends HttpServlet{
			private static Connection connection=null;
			protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
				int id=Integer.parseInt(req.getParameter("id"));
				String name=req.getParameter("name");
				String email=req.getParameter("email");
				String department=req.getParameter("department");
				int salary=Integer.parseInt(req.getParameter("salary"));
				
				employee e=new employee(id,name,email,department,salary);
				employeeboimpl s=new employeeboimpl();
				
				int i=s.save(e);
				PrintWriter out=res.getWriter();
				if(i>0) {
					out.println("Employee saved successfully....");
					List<employee> allEmployees=s.getAll();
					req.getRequestDispatcher("/view.jsp").forward(req,res);
				}
			}
}
