<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.bo.employeeboimpl" %>
<%@ page import="com.tap.employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Table</title>
    <style>
		body{
			background-color:#EEF5FF;
			font-family:'Arial',sans-serif;
			margin:0;
			padding:0;
		}
		h1{
			text-align:center;
			color:#161A30;
			margin-top:20px;
		}
		.container{
				display:flex;
				justify-content:center;
				align-items:center;
				flex-wrap:wrap;
				
		}
		.card{
				margin:20px;
				padding:20px;
				background-color:#ffffff;
				border-radius:10px;
				box-shadow: 0 0 10px rgba(0,0,0,0.1);
				width:300px;
				transition:transform 0.3s ease-in-out;
		}
		.card:hover{
				transform:scale(1.05);
		}
		.main{
				text-align:center;
				background-color:#006666;
				color:#fff;
				padding:5px;
				border-radius:10px;
				margin-bottom:10px;
			}
			.icon{
					font-size:24px;
					margin-right:10px;
					color:#7D0A0A;
			}
			.details{
					padding-left:20px;
					display:flex;
					align-items:center;
					margin-bottom: 10px;
				}
			.update,.delete{
					text-decoration:none;
					color:#fff;
					border-radius:5px;
					padding:8px 15px;
					margin-top:10px;
					cursor:pointer;
					transition:background-color 0.3s ease-in-out;
			}
			.update{
				background-color:#3377FF;
				margin-right:10px;
			}
			.delete{
					background-color:#dc3545;
			}
			.update:hover{
					background-color:#3498db;
			}
			.delete:hover{
				background-color:red;
			}
			.head{
				font-size:50px;
				text-align:center;
				background-color:#006666;
				color:#fff;
				padding:2px;
				border-radius:10px;
				margin-bottom: 5px;
				height:70px;
				width: 1000px;
				margin-top:10px;
				margin-left: 250px;	
				color:#fff;
				transition:transform 0.3s ease-in-out;
				
			}
			.head:hover{
				transform:scale(1.05);
			}
    </style>
</head>
<body>
    <div class="head">Employees Data</div>
    
       <div class="container">
       		 <% employeeboimpl obj=new employeeboimpl();
        	List<employee> allEmployees=obj.getAll();
        	if(allEmployees !=null){
        		for(employee e:allEmployees){
        			
        %>
          	<div class="card">
          		<div class="main"><strong>ID:</strong><%= e.getId() %></div>
          		<div class="details"><strong>Name:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= e.getName() %></div>
          		<div class="details"><strong>Email:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= e.getEmail() %></div>
          		<div class="details"><strong>Department:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= e.getDepartment() %></div>
          		<div class="details"><strong>Salary:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= e.getSalary() %></div>
          		<br>
          		<div class="actions">
          			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          			<a href="updateServlet?Id=<%= e.getId() %>" class="update">Update</a>
          			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          			<a href="deleteServlet?Id=<%= e.getId() %>" class="delete">Delete</a>
          		
          		</div>
          	
          	</div>     
           <%
        		}
        	}
           %>
       </div>
       <script type="module" src="https;//unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
       <script nomodule src="https;//unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
      
</body>
</html>
