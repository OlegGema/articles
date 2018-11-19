package com.example.articles;

import com.example.articles.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Assert;

public class ArticlesApplicationTests extends AbstractTest{

	@Override
	@Before
	public void setUp()
	{
		super.setUp();
	}


	@Test
	public void createTest() throws Exception {
		String url="/user/save";
		User user=new User();
		user.setId(3);
		user.setName("ivan");
		user.setAge(19);

		String inputJson=super.mapToJson(user);
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(url)
			.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status=mvcResult.getResponse().getStatus();
		Assert.assertEquals(200,status);

	}

	@Test
	public void deleteTest() throws Exception{
		String url="/user/delete/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200,status);
	}

}
