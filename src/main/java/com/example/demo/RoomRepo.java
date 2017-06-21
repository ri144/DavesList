package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/21/17.
 */
public interface RoomRepo extends CrudRepository<Room, Integer> {
    public Room findRoomById(int id);

}
