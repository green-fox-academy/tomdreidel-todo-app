package todoapp;

public class Task {
  String task;
  boolean completed;
  int order;

  public Task(String task) {
    this.task = task;
    this.completed = false;
  }

  public void addTask(String task) {
    this.task = task;
    this.completed = false;
  }



}
