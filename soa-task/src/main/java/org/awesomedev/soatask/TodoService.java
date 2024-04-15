package org.awesomedev.soatask;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface TodoService {
    @WebMethod
    ArrayList<String> getTodoList();

    @WebMethod
    void addTodo(String todo);
}
