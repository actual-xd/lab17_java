package ru.guu.lab17.view;


import java.sql.SQLException;

import ru.guu.lab17.model.Task;
import ru.guu.lab17.vm.TaskViewModel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.guu.lab17.vm.TaskViewModel;


public class TodoView {

    private final TaskViewModel viewModel;

    public TodoView(TaskViewModel viewModel){
        this.viewModel = viewModel;
    }

    public Scene createScene() {

        ListView<Task> taskListView = new ListView<>(viewModel.getTasks());
        taskListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                } else {
                    setText(task.getName());
                    setStyle(task.isCompleted() ? "-fx-strikethrough: true;" : "");
                }
            }
        });

        TextField newTaskField = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            try {
                viewModel.addTask(newTaskField.getText());
                newTaskField.clear();
        }catch (SQLException ex){
                ex.printStackTrace();
            }

        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask!= null){
                try{
                    viewModel.deleteTask(selectedTask);
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

        HBox inputPanel = new HBox(10, newTaskField, addButton, deleteButton);
        inputPanel.setAlignment(Pos.CENTER);

        VBox root = new VBox(10,taskListView, inputPanel);

        return new Scene(root, 400, 300);
    }
}
