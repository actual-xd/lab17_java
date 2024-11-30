package ru.guu.lab17;

import java.sql.SQLException;

import ru.guu.lab17.view.TodoView;
import ru.guu.lab17.vm.TaskViewModel;


import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException {

        TaskViewModel viewModel = new TaskViewModel();

        TodoView todoView = new TodoView(viewModel);

        primaryStage.setTitle("Todo List");
        primaryStage.setScene(todoView.createScene());
        primaryStage.show();

    }
}
