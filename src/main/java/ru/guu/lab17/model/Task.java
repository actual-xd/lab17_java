package ru.guu.lab17.model;

public class Task {
    private int id;
    private String name;
    private boolean completed;

    //Конструкторы, геттеры и сеттеры
    public Task(int id, String name, boolean completed)
    {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }
    public int getId(){
        return id;
    }

    public void setID(){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
