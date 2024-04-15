package org.awesomedev.soatask;

import java.util.ArrayList;

public class TodoService {
    static final private ArrayList<String> todos = new ArrayList<String>();

    static ArrayList<String> getTodos() { return todos; }

    static public void addTodo(String todo) {
        todos.add(todo);
    }
}
