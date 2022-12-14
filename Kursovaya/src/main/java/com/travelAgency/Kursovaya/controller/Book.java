package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.Booking;
import com.travelAgency.Kursovaya.entity.Room;
import com.travelAgency.Kursovaya.repository.BookingRepository;
import com.travelAgency.Kursovaya.repository.RoomRepository;
import com.travelAgency.Kursovaya.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Controller
public class Book {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/booking")
    private String bookNumber(@RequestParam(value = "rooms", required = false) String rooms, @RequestParam(value ="full_name", required = false) String full_name, @RequestParam(value = "phone", required = false) String phone, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "datein", required = false) String datein, @RequestParam(value = "dateout", required = false) String dateout, @RequestParam(value = "guests", required = false) int guests) {
        if(Objects.equals(rooms, "") || Objects.equals(full_name, "") || Objects.equals(email, "") || Objects.equals(phone, "") || guests == 0 || Objects.equals(datein, "") || Objects.equals(dateout, "")) {
            return "redirect:/bron?error_value";
        }
        else if(roomRepository.findRoom(rooms, false)) {
            if(dateout.compareTo(datein) < 0) {
                Booking booking = new Booking(roomRepository.getFirstByLuxuryLevelAndOccupied(rooms, false), full_name, email, phone, guests, dateout, datein);
                Room room = roomRepository.getFirstByLuxuryLevelAndOccupied(rooms, false);
                room.setOccupied(true);
                bookingRepository.save(booking);
                roomRepository.save(room);
                return "redirect:/bron?success";
            } else {
                Booking booking = new Booking(roomRepository.getFirstByLuxuryLevelAndOccupied(rooms, false), full_name, email, phone, guests, datein, dateout);
                Room room = roomRepository.getFirstByLuxuryLevelAndOccupied(rooms, false);
                room.setOccupied(true);
                bookingRepository.save(booking);
                roomRepository.save(room);
                return "redirect:/bron?success";
            }
        }
        else {
            return "redirect:/bron?error_book";
        }
    }
    @DeleteMapping("/delete_book/{id_booking}")
    private String delete_book(@PathVariable Integer id_booking){
        Booking booking = bookingRepository.getBookingByIdBooking(id_booking);
        Room room = booking.getRoom();
        room.setOccupied(false);
        bookingRepository.deleteByIdBooking(id_booking);
        bookingService.deleteBookingById(id_booking);
        return "redirect:/admin";
    }
}
