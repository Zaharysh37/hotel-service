package com.gpsolution.hotelservice;

import org.springframework.boot.SpringApplication;

public class TestHotelserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(HotelserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
