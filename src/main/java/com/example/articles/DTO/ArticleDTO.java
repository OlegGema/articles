package com.example.articles.DTO;

import lombok.Data;

@Data
public class ArticleDTO
{

  private String text;
  private String color;
  private int UserId;

  public ArticleDTO()
  {
  }
}
