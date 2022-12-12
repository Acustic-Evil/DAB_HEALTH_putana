package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Booking{

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer id_booking;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room", referencedColumnName = "id_room")
    private Room room;

    private String guest_full_name;
    private String guest_email;
    private String guest_phone;
    private Integer num_of_guests;
    private String checkin_date;
    private String checkout_date;

    public Booking() {
    }

    public Booking(String guest_full_name, String guest_email, String guest_phone, Integer num_of_guests, String checkin_date, String checkout_date) {
        this.guest_full_name = guest_full_name;
        this.guest_email = guest_email;
        this.guest_phone = guest_phone;
        this.num_of_guests = num_of_guests;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }

    public Integer getId_booking() {
        return id_booking;
    }

    public void setId_booking(Integer id_booking) {
        this.id_booking = id_booking;
    }

    public String getGuest_full_name() {
        return guest_full_name;
    }

    public void setGuest_full_name(String guest_full_name) {
        this.guest_full_name = guest_full_name;
    }

    public String getGuest_email() {
        return guest_email;
    }

    public void setGuest_email(String guest_email) {
        this.guest_email = guest_email;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }

    public Integer getNum_of_guests() {
        return num_of_guests;
    }

    public void setNum_of_guests(Integer num_of_guests) {
        this.num_of_guests = num_of_guests;
    }

    public String getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(String checkin_date) {
        this.checkin_date = checkin_date;
    }

    public String getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(String checkout_date) {
        this.checkout_date = checkout_date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
