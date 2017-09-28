package todoapp;

public class Main {

  public static void main(String[] args) {

    Todo todo = new Todo();

    if (args.length > 0) {
      if (args[1].equals("-k")) {
        System.out.println("yee");
      }
      else if (args[0].equals("-a")) {
        todo.addTodo(args[1]);
        System.out.println(todo.listTodo());
      }
      else if (args[0].equals("-l")) {
        System.out.println("====================================");
          for (int i = 0; i < todo.todoList.size(); i++) {
            if (todo.todoList[i])
            System.out.println("[" + checker + "] " + todo.todoList.get(i));
        }
        System.out.println(todo.listTodo());
      }
      else if (args[0].equals("-r")) {
        todo.removeTodo(args[1]);
        System.out.println(todo.listTodo());
      }
    }
  }
}