package com.example.articles.service;

import com.example.articles.DTO.ArticleDTO;
import com.example.articles.DTO.ArticleResponse;

import java.util.List;

public interface ArticleService
{
  void save(ArticleDTO article);
  List<ArticleResponse> findAll();
  void deleteArticleById(int id);
  void updateArticle(int id,ArticleDTO articleDTO);
}
