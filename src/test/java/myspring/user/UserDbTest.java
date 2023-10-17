package myspring.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-beans-user2.xml"})
public class UserDbTest {
	@Autowired // 빈이 곧 객체니깐 빈 등록해서 객체를 가져온다고 생각하면 될듯
	private DataSource dataSource;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void userService() {
		UserVO user = userService.getUser("dooly");
		assertEquals(2, user.getId());
	}
	
	@Test
	@Disabled
	public void userMapper() {
		UserVO user = userMapper.selectUserById("dooly"); // type safe함
		assertEquals(2, user.getId());
	}
	
	@Test
	@Disabled
	public void sqlSession() {
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		assertEquals(2, user.getId());
	}
	
	@Test
	@Disabled
	public void sessionFactory() {
		System.out.println(sqlSessionFactory.getClass().getName());
	}

	@Test
	@Disabled
	public void con() {
		try {
			Connection conn = dataSource.getConnection();
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println(metaData.getDatabaseProductName());
			System.out.println(metaData.getDriverName());
			System.out.println(metaData.getURL());
			System.out.println(metaData.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
