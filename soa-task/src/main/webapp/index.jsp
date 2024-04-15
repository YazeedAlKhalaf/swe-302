<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Todo Service | Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <h1 class="text-4xl font-bold">Welcome to the Todo Service :D</h1>
    <p class="text-xl font-medium">
      Manage your tasks efficiently and effectively.
    </p>
    <ul class="list-inside list-disc">
      <li>
        <a class="bg-teal-500 p-2 rounded-full font-bold" href="/todo-list.jsp"
          >View Todo List</a
        >
      </li>
      <li>
        <a class="bg-teal-500 p-2 rounded-full font-bold" href="/add-todo"
          >Add a New Todo</a
        >
      </li>
    </ul>
  </body>
</html>
