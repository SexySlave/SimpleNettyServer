package org.example;

import java.io.Serializable;

public class Packet implements Serializable { // implements Serializable can't be missed. Read more about Serializable in Internet
    private String stringValue;  // our variables with getters and setters

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    private int intValue;  // our variables with getters and setters

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}