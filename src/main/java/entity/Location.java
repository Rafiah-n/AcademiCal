package entity;

public class Location {
    private String buildingName;
    private String address;
    private Double longitude;
    private Double latitude;

    // setters

    public void setBuildingName(String building) {
        this.buildingName = building;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setLongitude(Double longitude){
        this.longitude = longitude;

    }
    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    // getters
    public String getAddress(){
        return this.address;
    }
    public String getBuildingName(){
        return this.buildingName;
    }


}