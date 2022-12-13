package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.Booking;
import com.travelAgency.Kursovaya.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public void deleteBookingById(Integer id){
        bookingRepository.deleteByIdBooking(id);
    }

}
