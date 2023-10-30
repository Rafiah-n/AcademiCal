package entity;

import java.time.*;

public class AssignmentEvent extends Event{

    private String type;
    private int percentage;
    private boolean required;
    private LocalDateTime lateDueDate;
    private double[] percentageReduction;


    public String getType(){
        return "";
    }
    public void setType(String type){

    }
    public int getPercentage(){
        return 0;
    }
    public void setPercentage(int percentage){

    }

    public boolean isRequired() {
        return required;
    }
    public void setRequired(boolean req){

    }
    public LocalDateTime getLateDueDate(){
        return lateDueDate;
    }
    public void setLateDueDate(LocalDateTime time){

    }
    public double getPercentageReduction(){
        return percentageReduction[0];
    }
    public void setPercentageReduction(double[] list){

    }
}
