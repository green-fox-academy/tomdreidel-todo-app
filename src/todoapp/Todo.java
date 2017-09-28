package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Todo {
  ArrayList<Task> todoList;
  Path filePath;
  int todoTotal;

  public Todo() {
    this.todoList = new ArrayList<>();
    this.filePath = Paths.get("/Users/tamasredly/greenfox/tomdreidel-todo-app/out/production/tomdreidel-todo-app/todo.txt");
    this.todoTotal = 0;

    if (!Files.exists(filePath)) {
      try {
        Files.createFile(filePath);
      }
      catch (IOException e) {
        System.out.println("Could not create file");
        return;
      }
    }
    try {
      Scanner fileReader = new Scanner(filePath);
      while (fileReader.hasNext()) {
        todoTotal ++;
        String[] dataLoader = fileReader.nextLine().split("¢¢");
        Task temp = new Task(Integer.parseInt(dataLoader[0]), Boolean.parseBoolean(dataLoader[1]), dataLoader[2]);
        todoList.add(temp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public void addTodo(String task) {
    Task newTask = new Task(todoTotal + 1, false, task);
    todoList.add(newTask);
    todoTotal ++;

    }



  public void listTodo() {
//    ArrayList<String> output = new ArrayList<>();
    String checker = " ";

    System.out.println("\nCommand Line Todo App\n=============================\n\nThings to do:\n");

    for (int i = 0; i < todoTotal; i++) {
      if (todoList.get(i).completed) {
        checker = "X";
      } else if (!todoList.get(i).completed) {
        checker = " ";
      }
       String concatLine =
            "[" + checker + "] - " + todoList.get(i).order + " - " + todoList.get(i).text + "\n";
//      output.add(concatLine);
        System.out.println(concatLine);
      }
    System.out.println();
      if ( todoTotal == 0) {
//      output.add("Nice! You have no things to do.");
        System.out.println("Nice! You have nothing to do.\n\n");
      }
      return;
    }


  public void removeTodo(String number) {
    int intNumber = Integer.parseInt(number) - 1;
    todoList.remove(todoList.get(intNumber));
    todoTotal --;
    save();
  }

  public void toggleCompletion(String order) {
    int intOrder = Integer.parseInt(order);
    if (todoList.get(intOrder - 1).completed) {
      todoList.get(intOrder - 1).completed = false;
    }
    else if (!todoList.get(intOrder - 1).completed) {
      todoList.get(intOrder - 1).completed = true;
    }
    save();
  }





  public String usage() {
    return "\nCommand Line Todo App\n=============================\n\nCommand line arguments:\n\n-l\tList all items\n-a\tAdd new item\n-r\tRemove item by index\n-c\tToggle item completion\n-h\tShow help screen\n\n-larch\tSecret Monty Python function\n\n";
  }

  public void save() {
    List<String> writeTemp = new ArrayList<>();
    for (int i = 0; i < todoList.size(); i++) {
      writeTemp.add(todoList.get(i).order + "¢¢" + todoList.get(i).completed + "¢¢" + todoList.get(i).text);
    }
    try {
      Files.write(filePath, writeTemp);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void montyTodo() {
    ArrayList<Task> output = new ArrayList<>();
    output.add(new Task(1, false, "And now something completely different"));
    output.add(new Task(2, false, "Monty Python’s"));
    output.add(new Task(3, false, "Flying Circus"));
    output.add(new Task(4, false, "The Larch"));
    String checker = " ";
    System.out.println("\nCommand Line Todo App\n=============================\n\nThings to do:\n");

    for (int i = 0; i < 4; i++) {

      if (output.get(i).completed) {
        checker = "X";
      } else if (!output.get(i).completed) {
        checker = " ";
      }
      String concatLine =
          "[" + checker + "] - " + output.get(i).order + " - " + output.get(i).text + "\n";
      System.out.println(concatLine);
    }
    System.out.println();
    return;
  }
}