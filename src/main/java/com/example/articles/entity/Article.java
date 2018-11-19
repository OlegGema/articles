package com.example.articles.entity;

import com.example.articles.utils.converter.ColorConverter;
import com.example.articles.utils.enums.Color;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Article extends PersistableEntity
{

  private String text;
  @Convert(converter = ColorConverter.class)
  private Color color;
  @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
  private User user;
}
