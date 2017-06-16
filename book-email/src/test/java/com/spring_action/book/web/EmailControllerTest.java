package com.spring_action.book.web;


import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class EmailControllerTest {

	@Test
	public void testEmailPage() throws Exception {
		EmailController controller = new EmailController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();//搭建MockMvc
		mockMvc.perform(MockMvcRequestBuilders.get("/")).//对"/"执行get请求
		andExpect(MockMvcResultMatchers.view().name("email"));//预期得到email视图
	}
}
