package com.todolist.persistance;
import static org.junit.Assert.fail;
import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;
import lombok.extern.log4j.Log4j;

/*
 	오라클 DB와의 연결이 정상적으로 이뤄졌는지 확인하는 테스으 예제. 콘솔창에서 info:~~문장이 뜨면 정상수행된 것이다.
  */

@Log4j
public class JDBCTests {
static {
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
}catch(Exception e) {
	e.printStackTrace();
	}
 }	

@Test
public void testConnection() {
	
	try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","C##book_ex","1234")){
		log.info(con);
	}catch(Exception e) {
		fail(e.getMessage());
	}
}


}
