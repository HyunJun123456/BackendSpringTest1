package myspring.di.strategy3.dao;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserDao {

	public List<UserVO> readAll();

	public UserVO read(int id);

}
