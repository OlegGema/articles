package com.example.articles.web;

import com.example.articles.DTO.UserDTO;
import com.example.articles.DTO.UserResponse;
import com.example.articles.service.UserService;
import com.example.articles.utils.enums.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class UserController
{
  @Autowired
  private UserService userService;
  @Autowired
  private EntityManager entityManager;

  @RequestMapping(value = "/user/save",method = RequestMethod.POST)
  public void saveUser(@RequestBody UserDTO userDTO){
    userService.save(userDTO);
  }

  @RequestMapping(value = "/user/getAll",method = RequestMethod.GET)
  public List<UserResponse> findAll(){
    return userService.findAll();
  }

  @RequestMapping(value = "/user/update/{userId}",method = RequestMethod.PATCH)
  public void updateUser(@PathVariable("userId")int id,@RequestBody UserDTO userDTO){
    userService.updateUser(id, userDTO);
  }

  @RequestMapping(value = "/user/delete/{userId}",method = RequestMethod.DELETE)
  public void deleteUser(@PathVariable("userId")int id){
    userService.deleteUserById(id);
  }

  @RequestMapping(value = "/user/findByAge/{age}",method = RequestMethod.GET)
  public List<UserResponse>findByAge(@PathVariable("age")int age){
    return userService.findByAge(age);
  }

  @RequestMapping(value = "/user/findByColor/{color}",method = RequestMethod.GET)
  public List<UserResponse>findByColor(@PathVariable("color")String color){
    Color value = Color.findByDBValue(color);
    Assert.notNull(value,"wrong color");
    return (List<UserResponse>) entityManager.createNamedQuery("User.findByColor").setParameter("color",value.getId()).getResultList();
  }

  @RequestMapping(value = "/user/findByArticles",method = RequestMethod.GET)
  public List<UserResponse>findByArticles(){
    return (List<UserResponse>) entityManager.createNamedQuery("User.findByArticles").getResultList();
  }

}
