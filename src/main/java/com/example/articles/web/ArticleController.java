package com.example.articles.web;

import com.example.articles.DTO.ArticleDTO;
import com.example.articles.DTO.ArticleResponse;
import com.example.articles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController
{
  @Autowired
  private ArticleService articleService;

  @RequestMapping(value = "/article/save",method = RequestMethod.POST)
  public void saveArticle(@RequestBody ArticleDTO articleDTO){
    articleService.save(articleDTO);
  }

  @RequestMapping(value = "/article/getAll",method = RequestMethod.GET)
  public List<ArticleResponse> findAll(){
    return articleService.findAll();
  }

  @RequestMapping(value = "/article/update/{articleId}",method = RequestMethod.PATCH)
  public void updateArticle(@PathVariable("articleId")int id,@RequestBody ArticleDTO articleDTO){
    articleService.updateArticle(id, articleDTO);
  }

  @RequestMapping(value = "/article/delete/{articleId}",method = RequestMethod.DELETE)
  public void deleteArticle(@PathVariable("articleId")int id){
    articleService.deleteArticleById(id);
  }
}
