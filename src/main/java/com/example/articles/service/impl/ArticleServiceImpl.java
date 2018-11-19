package com.example.articles.service.impl;

import com.example.articles.DTO.ArticleDTO;
import com.example.articles.DTO.ArticleResponse;
import com.example.articles.entity.Article;
import com.example.articles.entity.User;
import com.example.articles.repository.ArticleRepository;
import com.example.articles.repository.UserRepository;
import com.example.articles.service.ArticleService;
import com.example.articles.utils.enums.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService
{
  @Autowired
  ArticleRepository articleRepository;
  @Autowired
  UserRepository userRepository;

  @Override
  public void save(ArticleDTO articleDTO)
  {
    User user=userRepository.findById(articleDTO.getUserId());
    Article article=new Article();
    Color color=Color.findByDBValue(articleDTO.getColor());
    Assert.notNull(color,"wrong color");
    article.setText(articleDTO.getText());
    article.setColor(color);
    article.setUser(user);
    articleRepository.save(article);
  }

  @Override
  public List<ArticleResponse> findAll()
  {
    List<Article>articles=articleRepository.findAll();
    List<ArticleResponse>articleResponses=new ArrayList<>();
    articles.forEach(el->{
      articleResponses.add(ArticleResponse.builder().id(el.getId()).text(el.getText()).color(el.getColor()).build());
    });
    return articleResponses;
  }

  @Override
  @Transactional
  public void deleteArticleById(int id)
  {
    Article article=articleRepository.findById(id);
    Assert.notNull(article,"wrong article id");
    articleRepository.deleteArticleById(id);
  }

  @Override
  @Transactional
  public void updateArticle(int id, ArticleDTO articleDTO)
  {
    Article article=articleRepository.findById(id);
    Color color=Color.findByDBValue(articleDTO.getColor());
    Assert.notNull(article,"wrong article id");
    Assert.notNull(color,"wrong color");
    articleRepository.updateArticle(id,articleDTO.getText(),color);
  }
}
