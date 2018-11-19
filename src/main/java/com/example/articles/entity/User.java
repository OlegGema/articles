package com.example.articles.entity;

import com.example.articles.DTO.UserResponse;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SqlResultSetMapping(
  name="userResponse",
  classes = {
    @ConstructorResult(
      targetClass = UserResponse.class,
      columns = {
        @ColumnResult(name="id",type = Integer.class),
        @ColumnResult(name="name",type = String.class),
        @ColumnResult(name="age",type = Integer.class)

      }
    )
  }
)

@NamedNativeQueries(
  {
    @NamedNativeQuery(name = "User.findByColor",query = "SELECT DISTINCT user.id as id," +
      "user.name as name, " +
      "user.age as age " +
      "FROM USER inner JOIN article ON USER.id = article.user_id  " +
      "where color = :color GROUP BY article.id",resultSetMapping ="userResponse"),
    @NamedNativeQuery(name = "User.findByArticles",query = "SELECT user.id as id, " +
      "user.name as name, " +
      "user.age as age  FROM USER inner JOIN article ON USER.id = article.user_id " +
      "GROUP BY user.id " +
      "having count(*)=3;",resultSetMapping = "userResponse")
  }
)
public class User extends PersistableEntity
{

 private String name;
 private int age;
 @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.LAZY,mappedBy = "user")
 private List<Article>articles;


}
