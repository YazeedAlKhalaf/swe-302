package org.awesomedev.soatask;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "org.awesomedev.soatask.TodoService")
public class TodoServiceImpl implements TodoService {
    private static final ArrayList<String> todos = new ArrayList<>();

    @Override
    public ArrayList<String> getTodoList() {
        return todos;
    }

    @Override
    public void addTodo(String todo) {
        todos.add(todo);
    }
}
