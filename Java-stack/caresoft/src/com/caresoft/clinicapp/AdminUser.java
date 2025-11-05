package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!


    public AdminUser(Integer id,String role) {
        securityIncidents=new ArrayList<String>();
        setEmployeeID(id);
        setRole(role);
        super.setId(id);

    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    @Override
    public boolean assignPin(int pin){
        String s=String.valueOf(pin);
        int length=s.length();
        if (length >=6) {
            super.setPin(pin);
            return true;
        }
        return false;
    }
    @Override
    public boolean accessAuthorized(Integer id){
        if(super.getId().equals(id)){
            return true;
        }
        authIncident();
        return false;
    }
    public ArrayList<String> reportSecurityIncidents(){
        String note="the ids doesn't matched";
        securityIncidents.add(note);
        return securityIncidents;

    }
}
