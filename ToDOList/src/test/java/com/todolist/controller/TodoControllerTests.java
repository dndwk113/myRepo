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
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) //서버를 거치지 않고 진행하는 환경 구축
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
				mockMvc.perform(MockMvcRequestBuilders.get("/todo/list")) 	// 괄호 내 기입된 경로(URL)대로 외부에서 접근한 것 처럼 속인다. 컨트롤러에 매핑된 결과에 대응되는 결과가
				.andReturn()												// 로그로 송출된다.
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
				.param("d_day", "05/22/15")//객체타입... 어떻게 넘겨주는지? 시간 또한 지정패턴 입력시 자동으로 변환. newDate처럼 당일일자 자동변환은? & 입력되는 날짜도 삐꾸다. 시간 변환은 기본값이 월-일-연이며, 초과값은 상계한다. 향후 폼 수정? 
				.param("title", "테스트 새글 제목")
				.param("content","테스트 새글 내용")
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
		
		//일부 수정은 서비스처럼 안되나? 기존의 값을 기본값으로 설정 후 변경내용만 새로 덮어쓰기
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders
				.post("/todo/modify")
				.param("bno", "56")
				.param("importance", "2")
				.param("priorty", "7")
				.param("mngcode", "EEE#0001")
				.param("d_day", "05/23/19")
				.param("title", "수정된 테스트 새글 제목")
				.param("content", "수정된 테스트 새글 내용")
				.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
				
		log.info(resultPage);
				
	}
	
	
	
	
}//e_class
