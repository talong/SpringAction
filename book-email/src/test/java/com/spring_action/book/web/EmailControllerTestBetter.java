package com.spring_action.book.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.internal.matchers.IsCollectionContaining;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spring_action.book.data.EmailRepository;
import com.spring_action.book.domain.Email;

public class EmailControllerTestBetter {

	@Test
	public void shouldShowRecentEmailes() throws Exception {
		List<Email> exceptdEmailes = createEmailList(20);
		EmailRepository mockRepository = Mockito.mock(EmailRepository.class);
		Mockito.when(mockRepository.findEmailes(Long.MAX_VALUE, 20)).thenReturn(exceptdEmailes);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).
				setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).
				build();//搭建MockMvc
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles")).//对"/"执行get请求
		andExpect(MockMvcResultMatchers.view().name("spittles")).
		andExpect(MockMvcResultMatchers.model().attributeExists("spittleList")).
		andExpect(MockMvcResultMatchers.model().attribute("spittleList",
				IsCollectionContaining.hasItem(exceptdEmailes.toArray())));//预期得到email视图
		
		
	}
	
	private List<Email> createEmailList(int count) {
		List<Email> exceptdEmailes = new ArrayList<Email>();
		for (int i = 0;i < count; i++) {
			exceptdEmailes.add(new Email("Emailes " + i ,new Date()));
		}
		return exceptdEmailes;
	}
}
