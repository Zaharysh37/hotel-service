package com.gpsolution.hotelservice.core.mapper.basemapper;

import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
    componentModel = "spring",
    builder = @Builder(disableBuilder = true),
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface BaseMapper<E, D> {

    D toDto(E e);

    E toEntity(D d);

    List<D> toDtos(List<E> e);

    List<E> toEntities(List<D> d);

    E merge(@MappingTarget E entity, D dto);
}
