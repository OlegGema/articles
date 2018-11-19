package com.example.articles.service.impl;

import com.example.articles.DTO.UserDTO;
import com.example.articles.DTO.UserResponse;
import com.example.articles.entity.User;
import com.example.articles.repository.UserRepository;
import com.example.articles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  UserRepository userRepository;

  @Override
  public void save(UserDTO userDTO)
  {
    User user=new User();
    user.setName(userDTO.getName());
    user.setAge(userDTO.getAge());
    userRepository.save(user);

  }

  @Override
  public List<UserResponse> findAll()
  {
    List<User>users=userRepository.findAll();
    List<UserResponse>userResponses=new ArrayList<>();
    users.forEach(el->{
      userResponses.add(UserResponse.builder().id(el.getId()).name(el.getName()).age(el.getAge()).build());
    });
    return userResponses;
  }

  @Override
  @Transactional
  public void deleteUserById(int id)
  {
    User user=userRepository.findById(id);
    Assert.notNull(user,"wrong user id");
    userRepository.deleteUserById(id);
  }

  @Override
  @Transactional
  public void updateUser(int id, UserDTO userDTO)
  {
    User user=userRepository.findById(id);
    Assert.notNull(user,"wrong user id");
    userRepository.updateUser(id,userDTO.getName(),userDTO.getAge());
  }

  @Override
  public List<UserResponse> findByAge(int age)
  {
    List<User> users = userRepository.findByAge(age);
    List<UserResponse>userResponses=new ArrayList<>();
    users.forEach(el->{
      userResponses.add(UserResponse.builder().id(el.getId()).name(el.getName()).age(el.getAge()).build());
    });
    return userResponses;
  }

}
