package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.Booking;
import com.travelAgency.Kursovaya.entity.Room;
import com.travelAgency.Kursovaya.repository.BookingRepository;
import com.travelAgency.Kursovaya.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Book {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    Booking book = new Booking();

    @PostMapping("/booking")
    private String bookNumber(@RequestParam(value = "rooms") String rooms, @RequestParam(value ="full_name") String full_name, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email, @RequestParam("datein") String datein, @RequestParam("dateout") String dateout, @RequestParam("guests") int guests) {

        if(roomRepository.findRoom(rooms, false)) {
            Booking booking = new Booking(full_name, email, phone, guests, datein, dateout);

            book.setRoom(roomRepository.getFirstByLuxuryLevelAndOccupied(rooms, false));


            Room room = roomRepository.getFirstByLuxuryLevelAndOccupied(rooms, false);
            room.setOccupied(true);

            /*roomRepository.setRoom_occ(rooms, false);*/

            bookingRepository.save(booking);
            roomRepository.save(room);
            return "redirect:/";
        }
        else {
            return "redirect:/bron";
        }
    }
}
