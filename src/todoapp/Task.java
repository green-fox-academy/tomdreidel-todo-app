package todoapp;

public class Task {

  int order;
  boolean completed;
  String text;

  public Task(int order, boolean completed, String text) {
    this.order = order;
    this.completed = completed;
    this.text = text;
  }
}