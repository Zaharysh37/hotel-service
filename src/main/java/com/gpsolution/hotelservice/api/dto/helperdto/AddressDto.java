package com.gpsolution.hotelservice.api.dto.helperdto;

public record AddressDto(
    Integer houseNumber,
    String street,
    String city,
    String country,
    String postCode
) {
}
