package entity;

import com.google.api.client.util.DateTime;

import java.time.*;
import java.util.ArrayList;

public class AssignmentEvent extends Event{

    private String type;
    private int percentage;
    private boolean required;
    private LocalDateTime lateDueDate;
    //private ArrayList<Double> percentageReduction = new ArrayList<>();

    public AssignmentEvent(String name, Course course, LocalDateTime startTime, LocalDateTime endTime,
                           Location location, boolean completed, String type, int percentage, boolean required,
                           LocalDateTime lateDueDate) {
        super(name, course, startTime, endTime, location, completed);
        this.type = type;
        this.percentage = percentage;
        this.required = required;
        this.lateDueDate = lateDueDate;
    }

    public AssignmentEvent() {

    }


    public String getType(){
        return type;
    }
    public void setType(String t){
        type = t;
    }
    public int getPercentage(){
        return percentage;
    }
    public void setPercentage(int percent){
        percentage = percent;
    }

    public boolean isRequired() {
        return required;
    }
    public void setRequired(boolean req){
        required = req;
    }
    public LocalDateTime getLateDueDate(){
        return lateDueDate;
    }
    public void setLateDueDate(LocalDateTime time){
        lateDueDate =  time;
    }

    /*public ArrayList<Double> getPercentageReduction(){
        return percentageReduction;
    }
    public void setPercentageReduction(ArrayList<Double> list){
        percentageReduction = list;
    }

    public void addPercentage(double per){
        percentageReduction.add(per);
    }

    public void removePercentage(double per){
        percentageReduction.remove(per);
    }

     */
}
