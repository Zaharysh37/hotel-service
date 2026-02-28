package com.gpsolution.hotelservice.api.dto;

import com.gpsolution.hotelservice.api.dto.helperdto.AddressDto;
import com.gpsolution.hotelservice.api.dto.helperdto.ArrivalTimeDto;
import com.gpsolution.hotelservice.api.dto.helperdto.ContactsDto;

public record CreateHotelDto(
    String name,
    String description,
    String brand,
    AddressDto address,
    ContactsDto contacts,
    ArrivalTimeDto arrivalTime
) {
}
