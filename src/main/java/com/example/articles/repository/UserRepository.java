package com.example.articles.repository;

import com.example.articles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>
{
  @Query("from User u where u.id=:id")
  User findById(@Param("id")int id);

  @Query("update User set name=:name , age=:age where id=:id")
  @Modifying
  void updateUser(@Param("id")int id,@Param("name")String name,@Param("age")int age);

  @Modifying
  void deleteUserById(@Param("id")int id);

  @Query("from User where age>:age")
  List<User>findByAge(@Param("age")int age);


}
