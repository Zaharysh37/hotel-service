package com.gpsolution.hotelservice.core.service;

import com.gpsolution.hotelservice.api.dto.CreateHotelDto;
import com.gpsolution.hotelservice.api.dto.GetHotelDto;
import com.gpsolution.hotelservice.api.dto.GetHotelShortDto;
import java.util.List;
import java.util.Map;

public interface HotelService {

    List<GetHotelShortDto> getAllHotels();

    GetHotelDto getHotelById(Long id);

    List<GetHotelShortDto> searchHotels(String name,
                                        String brand,
                                        String city,
                                        String country,
                                        String amenities);

    GetHotelShortDto createHotel(CreateHotelDto createHotelDto);

    void createHotelAmenities(Long id, List<String> amenities);

    Map<String, Long> getHotelHistogram(String param);
}
