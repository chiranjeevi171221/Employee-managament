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

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet{
			protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
				res.setContentType("text/html");
				int id=Integer.parseInt(req.getParameter("Id"));
				employeeboimpl empbo=new employeeboimpl();
				PrintWriter out=res.getWriter();
				employee e=empbo.get(id);
				out.println("<body style='background-color:white; display:flex; text-align-items:center; justify-content:center;  font-family:Arial; sans-sarif'>");
				out.println("<div style='text-align:center; background-color:#006666; padding:50px; margin-top:100px; height:300px; width:300px; border-radius:10px;box-shadow: 0 0 10px rgba(255,255,255,0.1);'>");
				
				out.println("<h2 style='color:#F4B183;'> Update Student Details:</h2>");
				
				out.println("<form action='saveServlet' method='Get'>");
				out.println("<input type='hidden' name='Id' value='"+e.getId()+"'>");
				out.println("<div style='margin-bottom:10px;'> <input type='text' name='name' value='"+e.getName()+"' style='background-color:#263238; color:#FFFFFF; border:none;  padding:8px;'></div>");
				out.println("<div style='margin-bottom:10px;'> <input type='text' name='email' value='"+e.getEmail()+"' style='background-color:#263238; color:#fff; border:none; padding:8px;'></div>");
				out.println("<div style='margin-bottom:10px;'> <input type='text' name='department' value='"+e.getDepartment()+"' style='background-color:#263238; color:#FFFFFF; border:none; padding:8px;'></div>");
				out.println("<div style='margin-bottom:10px;'> <input type='number' name='salary' value='"+e.getSalary()+"' style='background-color:#263238; color:#FFFFFF; border:none; padding:8px;'></div>");
				out.println("<div> <input type='submit' value='save' style='width:80px; height:40px; background-color:#F4B183; color:#15202B; border:none; border-radius:5px; cursor:pointer;'></div>");
				out.println("</form>");
				
				out.println("</div>");
				out.println("</body>");
				
				out.println("<script type=\"module\" src=\"https;//unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js\"></script>");
				out.println("<script nomodule src=\"https;//unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js\"></script>");
			}
			protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
				doPost(req,res);
			}
			
}
