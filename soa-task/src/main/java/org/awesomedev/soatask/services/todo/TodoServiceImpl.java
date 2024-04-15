package org.awesomedev.soatask.services.todo;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;

@WebService(endpointInterface = "org.awesomedev.soatask.services.todo.TodoService")
public class TodoServiceImpl implements TodoService {
    private static final HashMap<String, String> todos = new HashMap<>();

    @Override
    public HashMap<String, String> getTodoList() {
        return todos;
    }

    @Override
    public void addTodo(String todo) {
        todos.put(new Date().toString(), todo);
    }

    @Override
    public String deleteTodo(String id) {
        return todos.get(id);
    }
}
