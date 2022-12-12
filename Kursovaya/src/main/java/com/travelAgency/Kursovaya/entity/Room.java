
package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
@Table
public class Room {

    @OneToOne(mappedBy="room")
    private Booking booking;

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer id_room;
    private boolean occupied;
    private String number_of_bedrooms;
    @Column(unique = true)
    private String room_number;
    private String luxuryLevel;

    public Room() {
    }
    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getNumber_of_bedrooms() {
        return number_of_bedrooms;
    }

    public void setNumber_of_bedrooms(String number_of_bedrooms) {
        this.number_of_bedrooms = number_of_bedrooms;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getLuxuryLevel() {
        return luxuryLevel;
    }

    public void setLuxuryLevel(String luxuryLevel) {
        this.luxuryLevel = luxuryLevel;
    }


    public Room(boolean occupied, String number_of_bedrooms, String room_number, String luxuryLevel) {
        this.occupied = occupied;
        this.number_of_bedrooms = number_of_bedrooms;
        this.room_number = room_number;
        this.luxuryLevel = luxuryLevel;
    }
}

