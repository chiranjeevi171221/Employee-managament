package com.tap;

public class employee {
			private int id;
			private String name;
			private String email;
			private String department;
			private int salary;
			public employee() {
				
			}
			public employee(int id, String name, String email, String department, int salary) {
				super();
				this.id = id;
				this.name = name;
				this.email = email;
				this.department = department;
				this.salary = salary;
			}
			public void setId(int id) {
				this.id = id;
			}
			public void setName(String name) {
				this.name = name;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public void setDepartment(String department) {
				this.department = department;
			}
			public void setSalary(int salary) {
				this.salary = salary;
			}
			public int getId() {
				return id;
			}
			public String getName() {
				return name;
			}
			public String getEmail() {
				return email;
			}
			public String getDepartment() {
				return department;
			}
			public int getSalary() {
				return salary;
			}
			@Override
			public String toString() {
				return "employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
						+ ", salary=" + salary + "]";
			}
			
			
}
