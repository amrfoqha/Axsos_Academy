package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
    protected Integer id;

	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
    // TO DO: Implement HIPAACompliantUser!
    Physician(Integer IDcopy){
        super.setId(IDcopy);
        patientNotes=new ArrayList<String>();



    }
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    @Override
    public boolean assignPin(int pin) {
        String s=String.valueOf(pin);
        int length=s.length();
        if(length==4) {
            super.setPin(pin);
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if(super.id.equals(confirmedAuthID))
            return true;
        return false;
    }

    // TO DO: Setters & Getters
}
