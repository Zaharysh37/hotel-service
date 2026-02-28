package com.gpsolution.hotelservice.core.mapper;

import com.gpsolution.hotelservice.api.dto.GetHotelShortDto;
import com.gpsolution.hotelservice.core.entity.Address;
import com.gpsolution.hotelservice.core.entity.Hotel;
import com.gpsolution.hotelservice.core.mapper.basemapper.GetBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GetBaseMapper.class)
public interface GetHotelShortDtoMapper extends GetBaseMapper<Hotel, GetHotelShortDto> {

    @Override
    @Mapping(source = "contacts.phone", target = "phone")
    @Mapping(target = "address", expression = "java(formatAddress(hotel.getAddress()))")
    GetHotelShortDto toDto(Hotel hotel);

    default String formatAddress(Address a) {
        if (a == null) return null;
        return a.getHouseNumber() + " " + a.getStreet() + ", " + a.getCity() + ", " + a.getPostCode() + ", " + a.getCountry();
    }
}
