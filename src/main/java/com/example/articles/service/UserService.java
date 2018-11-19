package com.example.articles.service;

import com.example.articles.DTO.UserDTO;
import com.example.articles.DTO.UserResponse;

import java.util.List;

public interface UserService
{
  void save(UserDTO user);
  List<UserResponse> findAll();
  void deleteUserById(int id);
  void updateUser(int id,UserDTO userDTO);
  List<UserResponse>findByAge(int age);
}
