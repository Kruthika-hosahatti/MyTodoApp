<%@page import="org.jsp.todo_app.dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div{
display:flex;
justify-content:space-evenly;
align-items:center;
height:100px;
}

img{
height:100px;
width:150px;
}

</style>
</head>
<body>

<% List<Task> tasks=(List<Task>) request.getAttribute("tasks");
%>
<%  if(!tasks.isEmpty()){
	%>
<center>
<table border="1">
<tr>
    <th>Task Image</th>
    <th>Task Name</th>
    <th>Task Description</th>
    <th>Created Time</th>
    <th>Status</th>
    <th>Delete</th>
    <th>Edit</th>
 </tr>
 
 <% for (Task task: tasks){
%>
 
 <tr>
  <td><img height="70px" width="70px" src="data:image/png;base64,<%=task.getEncodeImage()%>"/></td>
  <td><%=task.getName()%></td>
  <td><%=task.getDescription()%></td>
  <td><%=task.getAddedTime() %></td>
  <td><% if(task.isStatus()){%>Completed
   <%}else{%><a href="complete-task?id=<%=task.getId()%>"><button>Complete</button></a><%}%>
  </td>
  <td><a href="delete?id=<%=task.getId()%>"><button>Delete</button></a></td>
  <td><a href="edit-task.jsp?id=<%=task.getId()%>"><button>Edit</button></a></td>
 </tr>
 <%} %>
 
</table>
</center>
<%}%>
<div>
   <a href="add-task.html"><button>Add Task</button></a>
   <a href="logout"><button>Logout</button></a>
</div>

</body>
</html>