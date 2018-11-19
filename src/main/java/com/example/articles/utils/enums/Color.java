package com.example.articles.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import static java.util.Arrays.asList;

@AllArgsConstructor
@Getter
public enum Color
{
  RED(1,"red"),
  BLUE(2,"blue"),
  GREEN(3,"green"),
  YELLOW(4,"yellow"),
  PINK(5,"pink");

  private Integer id;
  private String dbValue;

  public static final List<Color>colors=asList(values());

  public static final Color findByDBValue(String dbValue)
  {
    return colors.stream().filter(el -> el.getDbValue().equals(dbValue)).findFirst().orElse(null);
  }

  public static final Color findById(Integer id)
  {
    return colors.stream().filter(el -> el.getId().equals(id)).findFirst().orElse(null);
  }
}
