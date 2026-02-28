package com.gpsolution.hotelservice.core.service.impl;

import com.gpsolution.hotelservice.api.dto.CreateHotelDto;
import com.gpsolution.hotelservice.api.dto.GetHotelDto;
import com.gpsolution.hotelservice.api.dto.GetHotelShortDto;
import com.gpsolution.hotelservice.core.dao.HotelRepository;
import com.gpsolution.hotelservice.core.entity.Hotel;
import com.gpsolution.hotelservice.core.mapper.CreateHotelDtoMapper;
import com.gpsolution.hotelservice.core.mapper.GetHotelDtoMapper;
import com.gpsolution.hotelservice.core.mapper.GetHotelShortDtoMapper;
import com.gpsolution.hotelservice.core.service.HotelService;
import jakarta.persistence.criteria.Join;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final CreateHotelDtoMapper createMapper;
    private final GetHotelDtoMapper getMapper;
    private final GetHotelShortDtoMapper shortMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GetHotelShortDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return shortMapper.toDtos(hotels);
    }

    @Override
    @Transactional(readOnly = true)
    public GetHotelDto getHotelById(Long id) {
        Hotel hotelDto = hotelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
        return getMapper.toDto(hotelDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetHotelShortDto> searchHotels(String name, String brand, String city,
                                               String country, String amenities) {

        Specification<Hotel> spec = Specification.allOf();

        if (name != null) spec = spec.and((root, query, criteriaBuilder)
            -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("name")), name.toLowerCase()));
        if (brand != null) spec = spec.and((root, query, criteriaBuilder)
            -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("brand")), brand.toLowerCase()) );
        if (city != null) spec = spec.and((root, query, criteriaBuilder)
            -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("address").get("city")), city.toLowerCase()) );
        if (country != null) spec = spec.and((root, query, criteriaBuilder)
            -> criteriaBuilder.equal(criteriaBuilder.lower(root.get("address").get("country")), country.toLowerCase()) );
        if (amenities != null) {
            spec = spec.and((root, query, criteriaBuilder)
                -> {
                Join<Hotel, String> amenitiesJoin = root.join("amenities");
                return criteriaBuilder.equal(criteriaBuilder.lower(amenitiesJoin), amenities.toLowerCase());
            });
        }

        List<Hotel> hotels = hotelRepository.findAll(spec);
        return shortMapper.toDtos(hotels);
    }

    @Override
    @Transactional
    public GetHotelShortDto createHotel(CreateHotelDto createHotelDto) {
        Hotel hotel = createMapper.toEntity(createHotelDto);
        Hotel savedHotel = hotelRepository.save(hotel);
        return shortMapper.toDto(savedHotel);
    }

    @Override
    @Transactional
    public void createHotelAmenities(Long id, List<String> amenities) {

        Hotel hotel = hotelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));

        if (hotel.getAmenities() != null) {
            hotel.getAmenities().addAll(amenities);
        } else {
            hotel.setAmenities(amenities);
        }

        hotelRepository.save(hotel);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Long> getHotelHistogram(String param) {
        return hotelRepository.getHistogram(param);
    }
}
