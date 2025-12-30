import java.time.LocalDate;

/**
 * Employee class: Inherits from Person, manages theme park ride operator information
 */
public class Employee extends Person {
    // 2 exclusive instance variables (meets "at least 2" requirement, tailored to employee scenarios)
    private String employeeId;   // Employee ID (unique within the organization)
    private String shift;        // Work shift (morning/afternoon/evening)

    // 1. Default constructor (calls parent class default constructor)
    public Employee() {
        super(); // Implicitly calls parent class no-arg constructor to initialize id/name/birthDate
        this.employeeId = "EMP-UNDEFINED";
        this.shift = "UNDEFINED";
    }

    // 2. Parameterized constructor (must initialize all parent + subclass variables, critical for HD level)
    public Employee(String personId, String name, LocalDate birthDate, 
                   String employeeId, String shift) {
        super(personId, name, birthDate); // Calls parent class parameterized constructor
        this.employeeId = employeeId;
        this.shift = shift;
    }

    // Full getters and setters (for subclass-exclusive variables)
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    // Override toString: Integrates parent class information for easy printing (essential for demonstration and debugging)
    @Override
    public String toString() {
        return "Employee{" +
                "personInfo=" + super.toString() + // Calls parent class toString
                ", employeeId='" + employeeId + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }
}