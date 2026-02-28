package com.gpsolution.hotelservice.core.dao.jparepository;

import com.gpsolution.hotelservice.core.entity.Hotel;
import jakarta.persistence.Tuple;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Profile({"h2", "postgre"})
public interface SpringDataHotelJpaRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAll(Specification<Hotel> spec);

    @Query("SELECT h.address.city AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.address.city")
    List<Tuple> countByCity();

    @Query("SELECT h.address.country AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.address.country")
    List<Tuple> countByCountry();

    @Query("SELECT h.brand AS name, COUNT(h) AS count FROM Hotel h GROUP BY h.brand")
    List<Tuple> countByBrand();

    @Query("SELECT a AS name, COUNT(h) AS count FROM Hotel h JOIN h.amenities a GROUP BY a")
    List<Tuple> countByAmenities();
}
