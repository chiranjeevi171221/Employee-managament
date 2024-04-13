package com.tap.app;

import java.io.IOException;
import java.io.PrintWriter;

import com.tap.bo.employeeboimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet{
			protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
				int Id=Integer.parseInt(req.getParameter("Id"));
				PrintWriter out=res.getWriter();
				employeeboimpl e1=new employeeboimpl();
				int i=e1.delete(Id);
				if(i>0) {
					
					res.setContentType("text/html");
					out.print("<center><h1>Deleted successfully</h1></center>");
					RequestDispatcher r=req.getRequestDispatcher("/view.jsp");
					r.include(req, res);
				}
				else {
						res.sendRedirect("error.jsp");
					
				}
			}
}
