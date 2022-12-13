
package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    void deleteByIdBooking(Integer id);

    Booking getBookingByIdBooking(Integer id);


}
