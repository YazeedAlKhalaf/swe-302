<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ page
import="org.awesomedev.soatask.services.todo.TodoServiceImpl" %> <%@ page
import="java.util.Map" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Todo List</title>

    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <h1 class="text-4xl font-bold">View your todos :D</h1>
    <ul class="list-inside list-disc">
      <jsp:useBean
        id="todoService"
        class="org.awesomedev.soatask.services.todo.TodoServiceImpl"
      />
      <c:forEach var="todo" items="${todoService.getTodoList().entrySet()}">
        <li data-id="${todo.key}">${todo.value}</li>
      </c:forEach>
    </ul>
    <a class="bg-teal-500 p-2 rounded-full font-bold" href="add-todo"
      >Add a New Todo</a
    >
  </body>
</html>
