package com.gpsolution.hotelservice.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetHotelShortDto(
    Long id,
    String name,
    String description,
    String address,
    String phone
) {
}
