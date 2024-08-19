package com.example.plant_ghar.service;

import com.example.plant_ghar.dto.UserDto;
import com.example.plant_ghar.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String save(UserDto userDto);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);
}
