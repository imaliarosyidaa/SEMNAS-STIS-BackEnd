package com.semnasstis.SemnasSTIS.service;

import com.semnasstis.SemnasSTIS.dto.UserDto;
import com.semnasstis.SemnasSTIS.entity.ERole;
import com.semnasstis.SemnasSTIS.entity.Role;
import com.semnasstis.SemnasSTIS.entity.User;
import com.semnasstis.SemnasSTIS.mapper.UserMapper;
import com.semnasstis.SemnasSTIS.repository.RoleRepository;
import com.semnasstis.SemnasSTIS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Error: Email Sudah Terdaftar. Tidak Bisa Mendaftar Dengan Email Sama!");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        User user = UserMapper.mapToUser(userDto);
        user.setRoles(roles);
        return UserMapper.mapToUserDto(userRepository.save(user));
    }
    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return UserMapper.mapToUserDto(user);
    }
    
    @Override
    public UserDto updateUser(UserDto userDto) {
        userRepository.save(UserMapper.mapToUser(userDto));
        return userDto;
    }
    
    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
    
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
            .map(user -> UserMapper.mapToUserDto(user))
            .collect(Collectors.toList());
    }
    
    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.isPresent() ? UserMapper.mapToUserDto(user.get()) : null;
    }
}
