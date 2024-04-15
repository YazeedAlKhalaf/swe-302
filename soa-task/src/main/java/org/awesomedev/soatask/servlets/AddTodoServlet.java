package org.awesomedev.soatask.servlets;

import org.awesomedev.soatask.services.todo.TodoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addTodoServlet", value = "/add-todo")
public class AddTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/add-todo-form.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String todo = req.getParameter("todo");

        new TodoServiceImpl().addTodo(todo);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Todo added successfully!</h1>");
        out.println("<p>New todo: " + todo + "</p>");
        out.println("<a href=\"/todo-list.jsp\">View all todos</a>");
        out.println("</body></html>");
    }
}
