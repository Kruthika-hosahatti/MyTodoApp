<!DOCTYPE html>
<%@page import="org.jsp.todo_app.dto.Task"%>
<%@page import="org.jsp.todo_app.dao.TodoDao"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
fieldset
 {
	height:250px;
	width:500px;
	margin-left: 500px;
	background-color:lightgrey;
	box-shadow: 3px 3px 3px black;
}

body
{
   background-color:lightblue;
}

h1{

margin-top: 180px;
}
</style>
</head>
<body>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	TodoDao dao=new TodoDao();
	Task task=dao.fetchTaskById(id);
%>
<center><h1>Edit Task Details</h1></center>
	
<form action="edit-task" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<%=task.getId()%>">
<fieldset>
	
	<br/>
	<br/>
	<label>Name:</label>
	
	
	<input type="text" name="name" value="<%=task.getName()%>">
	<br/>
	<br/>
	
	<label>Description:</label>
	<input type="text" name="desc"  value="<%=task.getDescription()%>">
	<br/>
	<br/>
	
	<label>Image:</label>
	<input type="file" name="image"><img height="50px" width="50px" src="data:image/png;base64,<%=task.getEncodeImage()%>"/>
	<br/>
	<br/>
	
	<button>Edit Task</button>
	<button type="reset">Cancel</button>
	
	
</fieldset>
</form>

</body>
</html>