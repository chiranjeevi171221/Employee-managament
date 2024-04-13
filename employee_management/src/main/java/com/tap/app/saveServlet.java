package com.tap.app;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.employee;
import com.tap.bo.employeeboimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet{
			protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
				res.setContentType("text/html");
				employeeboimpl empbo=new employeeboimpl();
				PrintWriter out=res.getWriter();
				
				int id=Integer.parseInt(req.getParameter("Id"));
				String name=req.getParameter("name");
				String email=req.getParameter("email");
				String department=req.getParameter("department");
				int salary=Integer.parseInt(req.getParameter("salary"));
				
				employee e=new employee(id,name,email,department,salary);
				
				int i=empbo.update(e);
				
				if(i>0) {
					out.println("<center><h1>Updated Successfully..</h1></center>");
					RequestDispatcher r=req.getRequestDispatcher("view.jsp");
					r.include(req, res);
				}
				else {
					res.sendRedirect("error.jsp");
				}
			}
			protected void doGet(HttpServletRequest req,HttpServletResponse res) {
				try {
					doPost(req,res);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}

