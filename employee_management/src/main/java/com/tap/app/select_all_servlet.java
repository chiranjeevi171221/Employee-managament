package com.tap.app;
import java.util.List;

import com.tap.employee;
import com.tap.bo.employeeboimpl;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class select_all_servlet extends HttpServlet{
			protected void service(HttpServletRequest req,HttpServletResponse res) {
				employee e=new employee();
				employeeboimpl e1=new employeeboimpl();
				List<employee> employees=e1.getAll();
				
			}
}
