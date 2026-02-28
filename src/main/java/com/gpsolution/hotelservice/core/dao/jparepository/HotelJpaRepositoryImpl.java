package com.gpsolution.hotelservice.core.dao.jparepository;

import com.gpsolution.hotelservice.core.dao.HotelRepository;
import com.gpsolution.hotelservice.core.entity.Hotel;
import jakarta.persistence.Tuple;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"h2", "postgre"})
@RequiredArgsConstructor
public class HotelJpaRepositoryImpl implements HotelRepository {

    private final SpringDataHotelJpaRepository hotelJpaRepository;

    @Override
    public Optional<Hotel> findById(long id) {
        return hotelJpaRepository.findById(id);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelJpaRepository.findAll();
    }

    @Override
    public List<Hotel> findAll(Specification<Hotel> spec) {
        return hotelJpaRepository.findAll(spec);
    }

    @Override
    public Map<String, Long> getHistogram(String param) {

        List<Tuple> tuples = switch (param.toLowerCase()) {
            case "city" -> hotelJpaRepository.countByCity();
            case "country" -> hotelJpaRepository.countByCountry();
            case "brand" -> hotelJpaRepository.countByBrand();
            case "amenities" -> hotelJpaRepository.countByAmenities();
            default -> throw new IllegalArgumentException("Unknown parameter: " + param);
        };

        return tuples.stream().collect(Collectors.toMap(
            t -> t.get("name", String.class),
            t -> t.get("count", Long.class)
        ));
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelJpaRepository.save(hotel);
    }
}
