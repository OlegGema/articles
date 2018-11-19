package com.example.articles.init;

import com.example.articles.entity.Article;
import com.example.articles.entity.User;
import com.example.articles.repository.ArticleRepository;
import com.example.articles.repository.UserRepository;
import com.example.articles.utils.enums.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInit implements ApplicationRunner
{
  private UserRepository userRepository;

  private ArticleRepository articleRepository;

  @Autowired
  public DataInit(UserRepository userRepository,ArticleRepository articleRepository) {
    this.userRepository = userRepository;
    this.articleRepository=articleRepository;
  }
  @Override
  public void run(ApplicationArguments args) throws Exception
  {
   long count=userRepository.count();
   if (count==0){

     User user=new User();
     user.setAge(21);
     user.setName("oleg");
     userRepository.save(user);

     Article article=new Article();
     article.setText("asd");
     article.setColor(Color.findByDBValue("blue"));
     user.setArticles(Arrays.asList(article));
     article.setUser(user);
     articleRepository.save(article);

     Article article1=new Article();
     article1.setText("qwe");
     article1.setColor(Color.findByDBValue("red"));
     user.setArticles(Arrays.asList(article1));
     article1.setUser(user);
     articleRepository.save(article1);

     Article article2=new Article();
     article2.setText("asdqwe");
     article2.setColor(Color.findByDBValue("green"));
     user.setArticles(Arrays.asList(article2));
     article2.setUser(user);
     articleRepository.save(article2);

     User user1=new User();
     user1.setAge(26);
     user1.setName("ivan");
     userRepository.save(user1);

     Article article3=new Article();
     article3.setText("asdqwe");
     article3.setColor(Color.findByDBValue("pink"));
     user1.setArticles(Arrays.asList(article3));
     article3.setUser(user1);
     articleRepository.save(article3);

     User user2=new User();
     user2.setAge(43);
     user2.setName("olga");
     userRepository.save(user2);

     Article article4=new Article();
     article4.setText("eqweqweqwe");
     article4.setColor(Color.findByDBValue("yellow"));
     user2.setArticles(Arrays.asList(article4));
     article4.setUser(user2);
     articleRepository.save(article4);

     User user3=new User();
     user3.setAge(12);
     user3.setName("petro");
     userRepository.save(user3);

     Article article5=new Article();
     article5.setText("eqweqweqwe");
     article5.setColor(Color.findByDBValue("yellow"));
     user3.setArticles(Arrays.asList(article5));
     article5.setUser(user3);
     articleRepository.save(article5);

     Article article6=new Article();
     article6.setText("eqweqweqwe");
     article6.setColor(Color.findByDBValue("red"));
     user3.setArticles(Arrays.asList(article6));
     article6.setUser(user3);
     articleRepository.save(article6);

     User user4=new User();
     user4.setAge(20);
     user4.setName("ira");
     userRepository.save(user4);

     Article article7=new Article();
     article7.setText("asd");
     article7.setColor(Color.findByDBValue("green"));
     user.setArticles(Arrays.asList(article7));
     article7.setUser(user4);
     articleRepository.save(article7);

     Article article8=new Article();
     article8.setText("qwe");
     article8.setColor(Color.findByDBValue("yellow"));
     user.setArticles(Arrays.asList(article8));
     article8.setUser(user4);
     articleRepository.save(article8);

     Article article9=new Article();
     article9.setText("asdqwe");
     article9.setColor(Color.findByDBValue("blue"));
     user.setArticles(Arrays.asList(article9));
     article9.setUser(user4);
     articleRepository.save(article9);

   }
  }
}
