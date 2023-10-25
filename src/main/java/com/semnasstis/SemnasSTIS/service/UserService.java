package com.semnasstis.SemnasSTIS.service;

import com.semnasstis.SemnasSTIS.dto.UserDto;
import com.semnasstis.SemnasSTIS.entity.ERole;
import java.util.List;

public interface UserService{
    public UserDto createUser(UserDto user);
    public UserDto getUserByEmail(String email);
    public UserDto updateUser(UserDto userDto);
    public boolean deleteUser(Long id);
    public List<UserDto> getAllUsers();
    public UserDto getUser(Long id);
}
