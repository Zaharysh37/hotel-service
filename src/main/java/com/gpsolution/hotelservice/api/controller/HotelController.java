package com.gpsolution.hotelservice.api.controller;

import com.gpsolution.hotelservice.api.dto.CreateHotelDto;
import com.gpsolution.hotelservice.api.dto.GetHotelDto;
import com.gpsolution.hotelservice.api.dto.GetHotelShortDto;
import com.gpsolution.hotelservice.core.service.impl.HotelServiceImpl;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/property-view")
@RequiredArgsConstructor
@Tag(name = "Hotels API", description = "API для управления отелями")
public class HotelController {

    private final HotelServiceImpl hotelService;

    @GetMapping("/hotels")
    @Operation(summary = "Получение списка всех отелей с их краткой информацией")
    public List<GetHotelShortDto> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/hotels/{id}")
    @Operation(summary = "Получение расширенной информации по конкретному отелю")
    public GetHotelDto getHotelById(@PathVariable @Parameter(description = "ID отеля") Long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Поиск отелей по параметрам", description = "Возвращает список отелей с краткой информацией")
    public List<GetHotelShortDto> searchHotels(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String brand,
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String country,
        @RequestParam(required = false) String amenities) {
        return hotelService.searchHotels(name, brand, city, country, amenities);
    }

    @PostMapping("/hotels")
    @Operation(summary = "Создание нового отеля")
    public GetHotelShortDto createHotel(@RequestBody CreateHotelDto dto) {
        return hotelService.createHotel(dto);
    }

    @PostMapping("/hotels/{id}/amenities")
    @Operation(summary = "Добавление списка удобств (amenities) к отелю")
    public void createHotelAmenities(
        @PathVariable Long id, @RequestBody List<String> amenities) {
         hotelService.createHotelAmenities(id, amenities);
    }

    @GetMapping("/histogram/{param}")
    @Operation(summary = "Получение количества отелей, сгруппированных по указанному параметру",
        description = "Допустимые параметры: brand, city, country, amenities")
    public Map<String, Long> getHistogram(
        @PathVariable @Parameter(description = "Параметр для группировки") String param) {
        return hotelService.getHotelHistogram(param);
    }
}
