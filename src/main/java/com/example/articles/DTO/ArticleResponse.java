package com.example.articles.DTO;

import com.example.articles.utils.enums.Color;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleResponse
{
  private int id;
  private String text;
  private Color color;
}
