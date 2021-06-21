package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class WorkLogEntry {

    private LocalDate StartDate = NOW_LOCAL_DATE();
    private String StartTime = NOW_LOCAL_TIME();
    private LocalDate EndDate = NOW_LOCAL_DATE();
    private SimpleStringProperty EndTime = new SimpleStringProperty(NOW_LOCAL_TIME());
    private String Subject = "";
    private ArrayList<String> Projects = new ArrayList<String>(
            Arrays.asList("Project 1 - Meeting", "Project 1 - Implement", "Design Project: Meeting", "Design Project: Wireframe", "WorkLog Project: Implement", "WorkLog Project: Database"));
    private String SelectedProject = "";

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }
    public LocalDate getEndDate() {
        return EndDate;
    }
    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }
    public LocalDate getStartDate() {
        return StartDate;
    }
    public void setEndTime(String endTime){
        EndTime.setValue(endTime);
    }
    public StringProperty endTimeProperty() {
        return EndTime;
    }
    public String getEndTime(){
        return EndTime.getValue();
    }
    public void setStartTime(String startTime){
        StartTime = startTime;
    }
    public String getStartTime(){
        return StartTime;
    }
    public void setSubject(String subject){
        Subject = subject;
    }
    public String getSubject(){
        return Subject;
    }
    public void setSelectedProject(String selectedProject){
        SelectedProject = selectedProject;
    }
    public String getSelectedProject(){
        return SelectedProject;
    }
    public ArrayList<String> getProjects(){
        return Projects;
    }

    private static final LocalDate NOW_LOCAL_DATE (){
        String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date , formatter);
        return localDate;
    }

    private static final String NOW_LOCAL_TIME (){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(date);
    }
}
