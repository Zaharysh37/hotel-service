package com.gpsolution.hotelservice.core.mapper.helpermapper;

import com.gpsolution.hotelservice.api.dto.helperdto.ArrivalTimeDto;
import com.gpsolution.hotelservice.core.entity.ArrivalTime;
import com.gpsolution.hotelservice.core.mapper.basemapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface ArrivalTimeDtoMapper extends BaseMapper<ArrivalTime, ArrivalTimeDto> {
}
