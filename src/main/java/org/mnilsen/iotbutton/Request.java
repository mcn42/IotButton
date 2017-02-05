/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mnilsen.iotbutton;

import java.util.Objects;

/**
 *
 * @author michaeln
 */
class Request {
    private String serialNumber;
    private String clickType;
    private String batteryVoltage;

    public Request(String serialNumber, String clickType, String batteryVoltage) {
        this.serialNumber = serialNumber;
        this.clickType = clickType;
        this.batteryVoltage = batteryVoltage;
    }
    
    
    //String ex = "{\"serialNumber\": \"G030MD021035UKR6\", \"batteryVoltage\": \"1598mV\", \"clickType\": \"SINGLE\"}";

    public Request() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getClickType() {
        return clickType;
    }

    public void setClickType(String clickType) {
        this.clickType = clickType;
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.serialNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Request other = (Request) obj;
        if (!Objects.equals(this.serialNumber, other.serialNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Request{" + "serialNumber=" + serialNumber + ", clickType=" + clickType + ", batteryVoltage=" + batteryVoltage + '}';
    }
    
    
}
