package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  List<String> todoList;
  Path filePath;

  public Todo() {
    this.todoList = new ArrayList<>();
    this.filePath = Paths.get("/Users/tamasredly/greenfox/tomdreidel-todo-app/out/production/tomdreidel-todo-app/todo.txt");
    if (!Files.exists(filePath)) {
    try {
      Files.createFile(filePath);
    } catch (IOException e) {
      System.out.println("Could not write file");
      }
    }
    listTodo();
  }


  public void addTodo(String task) {
    Task newTask = new Task(task);
    List<String> temp = null;
    try {
      temp = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("no such file");
    }
    int listSize = temp.size();
    newTask.order = listSize + 1;
    temp.add(newTask.task);
    try {
      Files.write(filePath, temp);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  public List<String> listTodo() {
    try {
      todoList = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("can't read file");
    }
    if (todoList.size() == 0) {
      System.out.println("You crushed all tasks like a monster!");
    }
    return todoList;
  }

  public void removeTodo(String number) {
    List<String> temp = null;
    int toDel = Integer.parseInt(number) - 1;
    try {
      temp = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("no such file");
    }
    temp.remove(toDel);
    try {
      Files.write(filePath, temp);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  public String usage() {
    return "Command Line todoapp.Todo Application\n=============================\n\nCommand line arguments:\n-l\tLists all the tasks\n-a\tAdds a new task\n-r\tRemoves a task\n-c\tCompletes a task";
  }
}