package com.gpsolution.hotelservice.core.mapper;

import com.gpsolution.hotelservice.api.dto.CreateHotelDto;
import com.gpsolution.hotelservice.core.entity.Hotel;
import com.gpsolution.hotelservice.core.mapper.basemapper.CreateBaseMapper;
import com.gpsolution.hotelservice.core.mapper.helpermapper.AddressDtoMapper;
import com.gpsolution.hotelservice.core.mapper.helpermapper.ArrivalTimeDtoMapper;
import com.gpsolution.hotelservice.core.mapper.helpermapper.ContactsDtoMapper;
import org.mapstruct.Mapper;

@Mapper(config = CreateBaseMapper.class,
    uses = {ContactsDtoMapper.class, AddressDtoMapper.class, ArrivalTimeDtoMapper.class})
public interface CreateHotelDtoMapper extends CreateBaseMapper<Hotel, CreateHotelDto> {
}
