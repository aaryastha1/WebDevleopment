package com.example.plant_ghar.controller;

import com.example.plant_ghar.dto.UserDto;
import com.example.plant_ghar.entity.User;
import com.example.plant_ghar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/data")
    public String getData() {
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody UserDto userDto) {
        try {
            userService.save(userDto);
            return "created data";
        } catch (Exception e) {
            e.printStackTrace();
            return "error creating data: " + e.getMessage();
        }
    }

    @GetMapping("/getAll")
    public List<User> getAllData() {
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }
}