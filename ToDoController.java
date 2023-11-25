package com.example.toDoList;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import org.controlsfx.control.PropertySheet;

import java.net.URL;
import java.time.LocalDate;
import javafx.scene.control.TableCell;
import java.util.ResourceBundle;

public class ToDoController implements Initializable {

    @FXML
    public TableView<NewTask> tableView;
    @FXML
    public DatePicker date;

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<NewTask, String> completed;

    @FXML
    private TableColumn<NewTask, String> inProgress;

    @FXML
    private TextField taskName;

    @FXML
    private TableColumn<NewTask, String> toDo;
    private ObservableList<NewTask> temp;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        toDo.setCellValueFactory(new PropertyValueFactory<NewTask, String>("combo"));
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        temp = tableView.getSelectionModel().getSelectedItems();

        toDo.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setStyle("");
                } else {
                    NewTask task = getTableView().getItems().get(getIndex());

                    LocalDate currentDate = LocalDate.now();

                    if (task.getDate() != null && task.getDate().isBefore(currentDate)) {
                        setStyle("-fx-background-color: red;");
                    } else {
                        setStyle("");
                    }
                    setText(item);
                }
            }
        });
    }

    @FXML
    public void addButton() {
        /*
         parameters: None
         returns: Nothing
         When the add button is hit, what is in the taskName text field and in the date field are placed into the
         to-do column
         */
        NewTask test = new NewTask(taskName.getText(), date.getValue());

        tableView.getItems().add(test);
        taskName.clear();
    }


    public void selected(MouseEvent event) {
        /*
         parameters: event
         return: Nothing
         When a newTask combo (task and date) is selected, it is allowed to be moved to different columns (in-progress
         and completed)
        */
        tableView.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Dragboard db = tableView.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putString(toDo.getText());
                db.setContent(content);
                event.consume();
            }
        });
    }
}
