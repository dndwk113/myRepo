package com.todolist.domain;

import java.util.Date;
import lombok.Data;


//1. 최초의 작업. DB로부터 데이터를 조회한 후 TodoVO에서 해당 값들을 받아온다. 이후 List형태로 이 값들을 저장한다
@Data
public class TodoVO {
	private Long bno;
	private Long importance;
	private Long priorty;
	private String mngcode;
	private Date d_day;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

}
