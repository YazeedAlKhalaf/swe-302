package org.awesomedev.soatask.servlets;

import org.awesomedev.soatask.services.todo.TodoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "todoListServlet", value= "/todo-list")
public class TodoListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.print("<h1>View Your Todos :D</h1>");
        out.println("<ul>");
        for (String todo : new TodoServiceImpl().getTodoList()) {
            out.println("<li>" + todo + "</li>");
        }
        out.println("</ul>");
        out.println("</br>");
        out.println("<a href=\"add-todo\">Add a New Todo</a>");
        out.println("</body></html>");
    }
}
