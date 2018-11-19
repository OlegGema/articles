package com.example.articles.repository;

import com.example.articles.entity.Article;
import com.example.articles.utils.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article,Integer>
{
  @Query("from Article a where a.id=:id")
  Article findById(@Param("id")int id);

  @Query("update Article set text=:text , color=:color where id=:id")
  @Modifying
  void updateArticle(@Param("id")int id,@Param("text")String name,@Param("color")Color color);

  @Modifying
  void deleteArticleById(@Param("id")int id);

}
