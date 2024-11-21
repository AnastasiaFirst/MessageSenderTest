package com.example.SpringBootApp.geo;

import com.example.SpringBootApp.entity.Location;

public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}