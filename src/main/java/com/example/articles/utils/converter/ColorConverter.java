package com.example.articles.utils.converter;

import com.example.articles.utils.enums.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color,Integer>
{

  @Override
  public Integer convertToDatabaseColumn(Color color)
  {
    return color!=null ? color.getId() : null;
  }

  @Override
  public Color convertToEntityAttribute(Integer integer)
  {
    return integer !=null ? Color.findById(integer) : null;
  }
}
