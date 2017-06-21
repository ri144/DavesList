package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by student on 6/21/17.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private RoomRepo roomrepo;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "roomList";
    }

    @RequestMapping("/roomList")
    public String done(Model model){
        Iterable<Room> values = roomrepo.findAll();
        model.addAttribute("values", values);
        return "roomList";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Room room, Model model){
        roomrepo.save(room);
        Iterable<Room> values = roomrepo.findAll();
        model.addAttribute("values", values);
        return "roomList";
    }

    @RequestMapping("/edit")
    public String edit(Model model){
        model.addAttribute("room", new Room());
        return "edit";
    }

    @RequestMapping("/roomdata/{id}")
    public String data(@PathVariable("id") String id, Model model){
        model.addAttribute("room", roomrepo.findRoomById(Integer.valueOf(id)));
        return "roomdata";
    }

}
