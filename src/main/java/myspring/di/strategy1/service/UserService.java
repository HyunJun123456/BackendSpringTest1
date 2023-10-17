package myspring.di.strategy1.service;

import java.util.List;

import myspring.user.vo.UserVO;
// 인터페이스에는 보통 어노테이션을 붙이지 않는다?
public interface UserService {
	
	public List<UserVO> getUserList();

	public UserVO getUser(int index);
	
}
