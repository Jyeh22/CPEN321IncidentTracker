package com.example.locationtest;

import com.google.android.gms.maps.model.LatLng;

public class Incident {

    private String title;
    private double latitude;
    private double longitude;
    private int severity;

    public Incident(String title, double latitude, double longitude, int severity){
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
    }

    public LatLng getLocation(){
        return new LatLng(latitude, longitude);
    }

    public String getTitle(){
        return title;
    }

    public int getSeverity(){
        return severity;
    }

    public double distanceFrom(LatLng someLocation){
        double p = Math.PI / 180;
        double lat1 = someLocation.latitude;
        double long1 = someLocation.longitude;
        double lat2 = latitude;
        double long2 = longitude;
        double a = 0.5 - Math.cos((lat2 - lat1)*p)/2 + Math.cos(lat1*p) * Math.cos(lat2*p) * (1-Math.cos((long2-long1)*p))/2;
        return 12742 * Math.asin(Math.sqrt(a));
    }
}
