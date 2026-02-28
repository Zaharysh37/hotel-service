package com.gpsolution.hotelservice.core.mapper.helpermapper;

import com.gpsolution.hotelservice.api.dto.helperdto.ContactsDto;
import com.gpsolution.hotelservice.core.entity.Contacts;
import com.gpsolution.hotelservice.core.mapper.basemapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface ContactsDtoMapper extends BaseMapper<Contacts, ContactsDto> {
}
