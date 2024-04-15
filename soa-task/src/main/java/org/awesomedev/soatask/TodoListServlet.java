package org.awesomedev.soatask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "todoListServlet", value= "/todo-list")
public class TodoListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.print("<h1>View Your Todos :D</h1>");
        out.println("<ul>");
        for (String todo : TodoService.getTodos()) {
            out.println("<li>" + todo + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
