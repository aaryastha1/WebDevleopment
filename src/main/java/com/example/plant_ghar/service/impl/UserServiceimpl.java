
package com.example.plant_ghar.service.impl;

import com.example.plant_ghar.config.PasswordEncoderUtil;
import com.example.plant_ghar.dto.UserDto;
import com.example.plant_ghar.entity.User;
import com.example.plant_ghar.repository.UserRepository;
import com.example.plant_ghar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public String save(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));

        userRepository.save(user);

        return "User successfully saved";
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}
