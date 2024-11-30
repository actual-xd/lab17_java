package ru.guu.lab17.vm;


import java.sql.SQLException;

import ru.guu.lab17.model.Task;
import ru.guu.lab17.model.TaskDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class TaskViewModel {
    private final TaskDatabase taskDatabase;

    private final ObservableList<Task> tasks = FXCollections.observableArrayList();

    public TaskViewModel() throws SQLException{
        this.taskDatabase = new TaskDatabase();
        loadTasks();
    }

    public ObservableList<Task> getTasks(){
        return tasks;
    }

    public void addTask(String name) throws SQLException{
        Task newTask = new Task(0,name,false);
        taskDatabase.addTask(newTask);
        loadTasks();
    }

    public void deleteTask(Task task) throws SQLException{
        taskDatabase.deleteTask(task.getId());
        loadTasks();
    }

    public void toggleTaskCompletion(Task task) throws SQLException{
        task.setCompleted(!task.isCompleted());
        taskDatabase.updateTask(task);
        loadTasks();
    }

    private void loadTasks() throws SQLException {
        tasks.setAll(taskDatabase.getAllTasks());
    }
}
