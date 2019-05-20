package com.todolist.domain;

import java.util.Date;
import lombok.Data;


//1. ������ �۾�. DB�κ��� �����͸� ��ȸ�� �� TodoVO���� �ش� ������ �޾ƿ´�. ���� List���·� �� ������ �����Ѵ�
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
