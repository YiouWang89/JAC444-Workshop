package com.example.lab6;

public class BMIStatus {
    private  String BMI;
    private String status;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    BMIStatus(String BMI, String status, int id){
        this.BMI = BMI;
        this.status = status;
        this.id = id;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
