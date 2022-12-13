
package com.travelAgency.Kursovaya.repository;

import com.travelAgency.Kursovaya.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    default Boolean findRoom(String LuxuryLevel, Boolean Occupied) {
        return getFirstByLuxuryLevelAndOccupied(LuxuryLevel, Occupied) != null;
    }

    Room getFirstByLuxuryLevelAndOccupied(String LuxuryLevel, Boolean Occupied);

    /*default void setRoom_occ(String LuxuryLevel, Boolean Occupied) {
        Room room = getFirstByLuxuryLevelAndOccupied(LuxuryLevel, Occupied);
        room.setOccupied(true);
    }*/

    /*Room getRoomByIdRoom(Room id);*/
}