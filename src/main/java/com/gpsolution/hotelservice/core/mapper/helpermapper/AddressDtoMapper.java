package com.gpsolution.hotelservice.core.mapper.helpermapper;

import com.gpsolution.hotelservice.api.dto.helperdto.AddressDto;
import com.gpsolution.hotelservice.core.entity.Address;
import com.gpsolution.hotelservice.core.mapper.basemapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface AddressDtoMapper extends BaseMapper<Address, AddressDto> {
}
