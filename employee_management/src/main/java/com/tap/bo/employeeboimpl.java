package com.tap.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.employee;

public class employeeboimpl implements employeebo {
	private static Connection connection=null;
	private static ResultSet res=null;
	private static Statement statement=null;
	private static PreparedStatement prepareStatement=null;
	private final static String Insert_Query="insert into `employee`(`id`,`name`,`email`,`department`,`salary`) values(?,?,?,?,?)";
	private final static String DELETE_QUERY="delete from `employee` where `id` =?";
	private final static String UPDATE_QUERY="update `employee` set `name`=?, `email`=?, `department`=?, `salary`=? where `id`=?";
	private final static String SELECT_QUERY="select * from `employee` where `id` =?";
	private final static String SELECT_ALL_QUERY="select * from `employee`";
	public employeeboimpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcclasses","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int save(employee e) {
		int i=0;
		try {
			prepareStatement =connection.prepareStatement(Insert_Query);
			prepareStatement.setInt(1, e.getId());
			prepareStatement.setString(2, e.getName());
			prepareStatement.setString(3, e.getEmail());
			prepareStatement.setString(4, e.getDepartment());
			prepareStatement.setInt(5, e.getSalary());
			
			i=prepareStatement.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return i;
	}

	@Override
	public int delete(int id) {
		try {
			prepareStatement=connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, id);
			return prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(employee e) {
		return delete(e.getId());
	}

	@Override
	public int update(employee e) {
		try {
			prepareStatement=connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, e.getName());
			prepareStatement.setString(2, e.getEmail());
			prepareStatement.setString(3, e.getDepartment());
			prepareStatement.setInt(4, e.getSalary());
			prepareStatement.setInt(5, e.getId());
			return prepareStatement.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public employee get(int id) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, id);
			res=prepareStatement.executeQuery();
			if(res.next()) {
				int id2=res.getInt("id");
				String name=res.getString("name");
				String email=res.getString("email");
				String department=res.getString("department");
				int salary=res.getInt("salary");
				return new employee(id2,name,email,department,salary);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<employee> getAll() {
		ArrayList<employee> employees=new ArrayList<employee>();
		
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int id=res.getInt("id");
				String name=res.getString("name");
				String email=res.getString("email");
				String department=res.getString("department");
				int salary=res.getInt("salary");
				
				employee e=new employee(id,name,email,department,salary);
				employees.add(e);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return employees;
	}

}
