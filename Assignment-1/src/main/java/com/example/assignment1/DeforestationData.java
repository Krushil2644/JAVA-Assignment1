package com.example.assignment1;

/**
 * Represents data related to deforestation.
 */
public class DeforestationData {
    // Fields to store deforestation data
    private int id;
    private int year;
    private double areaAffected;
    private String cause;
    private String description;

    /**
     * Constructor to initialize all fields of the DeforestationData object.
     *
     * @param id the unique identifier for the deforestation data
     * @param year the year when deforestation occurred
     * @param areaAffected the area affected by deforestation in square kilometers
     * @param cause the cause of deforestation
     * @param description additional description about the deforestation event
     */
    public DeforestationData(int id, int year, double areaAffected, String cause, String description) {
        this.id = id;
        this.year = year;
        this.areaAffected = areaAffected;
        this.cause = cause;
        this.description = description;
    }

    /**
     * Overloaded constructor to initialize id and year fields.
     *
     * @param id the unique identifier for the deforestation data
     * @param year the year when deforestation occurred
     */
    public DeforestationData(int id, int year) {
        this.id = id;
        this.year = year;
    }

    /**
     * Overloaded constructor to initialize year and a string representation of a number.
     *
     * @param number a string representation of a number (not used in this context)
     * @param year the year when deforestation occurred
     */
    public DeforestationData(String number, int year) {
        // The number parameter is not utilized in the current context
    }

    // Getter and setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Getter and setter methods for areaAffected
    public double getAreaAffected() {
        return areaAffected;
    }

    public void setAreaAffected(double areaAffected) {
        this.areaAffected = areaAffected;
    }

    // Getter and setter methods for cause
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    // Getter and setter methods for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
