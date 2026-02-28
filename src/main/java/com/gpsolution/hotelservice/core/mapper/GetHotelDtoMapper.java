package com.gpsolution.hotelservice.core.mapper;

import com.gpsolution.hotelservice.api.dto.GetHotelDto;
import com.gpsolution.hotelservice.core.entity.Hotel;
import com.gpsolution.hotelservice.core.mapper.basemapper.GetBaseMapper;
import com.gpsolution.hotelservice.core.mapper.helpermapper.AddressDtoMapper;
import com.gpsolution.hotelservice.core.mapper.helpermapper.ArrivalTimeDtoMapper;
import com.gpsolution.hotelservice.core.mapper.helpermapper.ContactsDtoMapper;
import org.mapstruct.Mapper;

@Mapper(config = GetBaseMapper.class,
    uses = {ContactsDtoMapper.class, AddressDtoMapper.class, ArrivalTimeDtoMapper.class})
public interface GetHotelDtoMapper extends GetBaseMapper<Hotel, GetHotelDto>{
}
