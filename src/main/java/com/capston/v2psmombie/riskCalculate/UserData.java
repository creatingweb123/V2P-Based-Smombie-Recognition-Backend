package com.in28minutes.rest.webservices.restfulwebwervices.todo;

public class UserData {
    private double lat;
    private double lon;
    private double speed;
    private double direction;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public UserData(double lat, double lon, double speed, double direction) {
        this.lat = lat;
        this.lon = lon;
        this.speed = speed;
        this.direction = direction;
    }

    public UserData() {
    }

}
