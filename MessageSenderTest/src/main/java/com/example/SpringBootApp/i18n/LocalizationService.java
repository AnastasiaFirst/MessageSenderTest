package com.example.SpringBootApp.i18n;


import com.example.SpringBootApp.entity.Country;

public interface LocalizationService {

    String locale(Country country);
}