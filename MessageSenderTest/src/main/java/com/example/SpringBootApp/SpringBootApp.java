package com.example.SpringBootApp;

import com.example.SpringBootApp.geo.GeoService;
import com.example.SpringBootApp.geo.GeoServiceImpl;
import com.example.SpringBootApp.i18n.LocalizationService;
import com.example.SpringBootApp.i18n.LocalizationServiceImpl;
import com.example.SpringBootApp.sender.MessageSender;
import com.example.SpringBootApp.sender.MessageSenderImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootApp {

	//Тестовый пример
	public static void main(String[] args) {
		GeoService geoService = new GeoServiceImpl();
		LocalizationService localizationService = new LocalizationServiceImpl();
		MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
		messageSender.send(headers);
	}
}