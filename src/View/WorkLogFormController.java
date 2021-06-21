package View;

import BusinessLogic.WorkLogEntryService;
import Model.WorkLogEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class WorkLogFormController implements Initializable {

    private WorkLogEntry model;

    @FXML
    private DatePicker startDate;

    @FXML
    private TextField startTime;

    @FXML
    private DatePicker endDate;

    @FXML
    private TextField endTime;

    @FXML
    private TextField subject;

    @FXML
    ComboBox<String> projectList;

    @FXML
    Button saveWorkLog;

    public void initModel(WorkLogEntry model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
        startDate.setValue(model.getStartDate());
        endDate.setValue(model.getEndDate());
        //endTime.setText(model.getEndTime());
        endTime.textProperty().bindBidirectional(model.endTimeProperty());
        subject.setText(model.getSubject());
        subject.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setSubject(newValue);
        });
        projectList.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setSelectedProject(newValue);
        });

        projectList.getItems().setAll(model.getProjects());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Because of the prototype we create a new instance of a worklogmodel
        initModel(new WorkLogEntry());

        // in a real application we would get the model from the business layer
        // WorkLogEntryService service = new WorkLogEntryService();
        // initModel(service.GetWorkLogEntry());

        saveWorkLog.setOnAction( (ActionEvent e) ->{
            // in a real application we would store the model here!
            // for the prototype instead we could just navigate to another view

            WorkLogEntryService service = new WorkLogEntryService();
            service.SaveWorkLog(this.model);
        });
    }
}
