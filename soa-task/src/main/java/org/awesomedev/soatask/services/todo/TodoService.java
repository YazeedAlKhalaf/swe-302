package org.awesomedev.soatask.services.todo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;

@WebService
public interface TodoService {
    @WebMethod
    HashMap<String, String> getTodoList();

    @WebMethod
    void addTodo(String todo);

    @WebMethod
    String deleteTodo(String id);
}
