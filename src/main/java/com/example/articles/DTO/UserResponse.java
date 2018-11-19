package com.example.articles.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse
{
  private int id;
  private String name;
  private int age;

  public UserResponse(int id, String name, int age)
  {
    this.id = id;
    this.name = name;
    this.age = age;
  }
}
