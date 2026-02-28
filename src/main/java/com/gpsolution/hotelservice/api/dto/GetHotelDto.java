package com.gpsolution.hotelservice.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gpsolution.hotelservice.api.dto.helperdto.AddressDto;
import com.gpsolution.hotelservice.api.dto.helperdto.ArrivalTimeDto;
import com.gpsolution.hotelservice.api.dto.helperdto.ContactsDto;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetHotelDto(
    Long id,
    String name,
    String description,
    String brand,
    AddressDto address,
    ContactsDto contacts,
    ArrivalTimeDto arrivalTime,
    List<String> amenities
) {
}
