package org.docencia.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import org.docencia.hotel.persistence.jpa.impl.HotelJpaRepository;
import org.docencia.hotel.model.Hotel;

@SpringBootTest
@ActiveProfiles("test")
public class HotelJpaRepositoryTest {

    @Autowired
    private HotelJpaRepository hotelRepository;

    private Hotel baseHotel;
    
    @BeforeEach
    @Transactional
    void beforeEach() {
        baseHotel = new Hotel();
        baseHotel.setName("Beach Hotel");
        baseHotel.setAddress("Avenue 321");

        baseHotel = hotelRepository.save(baseHotel);

        assertThat(baseHotel.getId()).isNotNull();
    }

    @Test
    @Transactional
    void testExistAndFindByIdAndFindAll() {
        String id = baseHotel.getId();

        assertThat(hotelRepository.exists(id)).isTrue();

        Hotel foundHotel = hotelRepository.findById(id);
        assertThat(foundHotel).isNotNull();
        assertThat(foundHotel.getName()).isEqualTo("Beach Hotel");
        assertThat(foundHotel.getAddress()).isEqualTo("Avenue 321");

        assertThat(hotelRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    @Transactional
    void deleteHotelTest() {
        String id = baseHotel.getId();

        boolean delete = hotelRepository.delete(id);

        assertThat(delete).isTrue();
        assertThat(hotelRepository.exists(id)).isFalse();
        assertThat(hotelRepository.findById(id)).isNull();
    }
}
