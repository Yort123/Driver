package com.example.toDoList;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class NewTask {

    private final SimpleStringProperty todo;
    private final SimpleStringProperty completed;


    private final LocalDate dueDate;
    private final String taskName;
    private final String combo;
    private String status; // Added to track the status of the task

    public NewTask(String taskName, LocalDate dueDate) {
        this.todo = new SimpleStringProperty("");
        this.completed = new SimpleStringProperty("");

        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = "To-Do"; // Initial status
        this.combo = "Task:  " + taskName + "  Date:  " + String.valueOf(dueDate); // combo variable what is to be displayed in the table

    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getCombo(){
        return this.combo;
    }

    public String getStatus() {
        return status;
    }

    public SimpleStringProperty todoProperty() {
        return todo;
    }

    public SimpleStringProperty completedProperty() {
        return completed;
    }


    // Method to update the status based on the target column
    public void updateStatus(String targetColumnId) {
        switch (targetColumnId) {
            case "toDo":
                status = "To-Do";
                break;
            case "completed":
                status = "Completed";
                break;
            default:
                // Handle other cases or provide a default behavior
                break;
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }
}