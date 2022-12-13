package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.Room;
import com.travelAgency.Kursovaya.repository.BookingRepository;
import com.travelAgency.Kursovaya.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookingRepository bookingRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

}
