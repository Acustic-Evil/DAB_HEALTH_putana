package com.travelAgency.Kursovaya.controller;

import com.travelAgency.Kursovaya.entity.Admins;
import com.travelAgency.Kursovaya.entity.Booking;
import com.travelAgency.Kursovaya.entity.Room;
import com.travelAgency.Kursovaya.service.BookingService;
import com.travelAgency.Kursovaya.service.HotelService;
import com.travelAgency.Kursovaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class Admin {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("")
    public String getAdminPage(Model model) {
        List<Booking> booking = bookingService.getAll();
        List<Room> rooms = hotelService.getAllRooms();
        model.addAttribute("bookingList", booking);
      /*  model.addAttribute("roomsList", rooms);*/

        return "foradm";
    }

/*    @GetMapping("")
    public String getAdminPage() {return "foradm";}*/

    @GetMapping("/sign_up")
    public String getSignPage() {return "sign_up";}

    @Autowired
    UserService userService;

    @PostMapping("/sign_up")
    public String addNewUsers(@RequestParam(value = "username")String username, @RequestParam(value = "password")String password, @RequestParam(value = "role", required = false)String role){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!userService.saveUser(new Admins("admin", username, bCryptPasswordEncoder.encode(password)))){
            return "redirect:/admin/sign_up";
        }
        System.out.println("New user: "+username + " " +role);
        return "redirect:/admin";
    }
}
