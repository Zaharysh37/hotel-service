package com.gpsolution.hotelservice.core.dao;

import com.gpsolution.hotelservice.core.entity.Hotel;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;

public interface HotelRepository {
    Optional<Hotel> findById(long id);
    List<Hotel> findAll();
    List<Hotel> findAll(Specification<Hotel> spec);
    Map<String, Long> getHistogram(String param);
    Hotel save(Hotel hotel);
}
