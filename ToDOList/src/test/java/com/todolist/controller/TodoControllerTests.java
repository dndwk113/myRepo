package com.todolist.controller;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //������ ��ġ�� �ʰ� �����ϴ� ȯ�� ����
@Log4j
public class TodoControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/todo/list")) 	// ��ȣ �� ���Ե� ���(URL)��� �ܺο��� ������ �� ó�� ���δ�. ��Ʈ�ѷ��� ���ε� ����� �����Ǵ� �����
				.andReturn()												// �α׷� ����ȴ�.
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRegister()throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
				.post("/todo/register")
				.param("importance", "1")
				.param("priorty", "10")
				.param("mngcode", "GFD#0008")
				//.requestAttr("d_day", new Date())
				.param("d_day", "05/22/15")//��üŸ��... ��� �Ѱ��ִ���? �ð� ���� �������� �Է½� �ڵ����� ��ȯ. newDateó�� �������� �ڵ���ȯ��? & �ԷµǴ� ��¥�� �߲ٴ�. �ð� ��ȯ�� �⺻���� ��-��-���̸�, �ʰ����� ����Ѵ�. ���� �� ����? 
				.param("title", "�׽�Ʈ ���� ����")
				.param("content","�׽�Ʈ ���� ����")
				.param("writer","user00")
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	@Test
	public void testGet() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders
						.get("/todo/get")
						.param("bno", "10"))
						.andReturn()												
						.getModelAndView()
						.getModelMap());
	}
	
	@Test
public void testModify() throws Exception {
		
		//�Ϻ� ������ ����ó�� �ȵǳ�? ������ ���� �⺻������ ���� �� ���泻�븸 ���� �����
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders
				.post("/todo/modify")
				.param("bno", "56")
				.param("importance", "2")
				.param("priorty", "7")
				.param("mngcode", "EEE#0001")
				.param("d_day", "05/23/19")
				.param("title", "������ �׽�Ʈ ���� ����")
				.param("content", "������ �׽�Ʈ ���� ����")
				.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
				
		log.info(resultPage);
				
	}
	
	
	
	
}//e_class
