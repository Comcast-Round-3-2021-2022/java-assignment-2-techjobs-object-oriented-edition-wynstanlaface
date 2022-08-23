package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    private int ID;
    private static int nextID = 1;
    private String value;
    // automatically assign a unique Id with no-arg constructor
    public JobField(){
        this.ID=nextID;
        nextID++;
    }
    public JobField(String value) {
        this();
        this.value = value;
    }


    public int getID() {
        return ID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getID() == jobField.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    @Override
    public String toString() {
        return "JobField{" +
                "ID=" + ID +
                ", value='" + value + '\'' +
                '}';
    }
}
