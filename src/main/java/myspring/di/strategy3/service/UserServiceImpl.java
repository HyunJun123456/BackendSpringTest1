package myspring.di.strategy3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import myspring.di.strategy3.dao.UserDao;
import myspring.user.vo.UserVO;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userdao; // 하나만 떠 있어서 그냥 받아옴
	
	// setter 메서드로 주입을 시켜준다.
//	public void setUserdao(UserDao userdao) {
//		this.userdao = userdao;
//	}

	public List<UserVO> getUserList() {
		return userdao.readAll();
	}

	@Override
	public UserVO getUser(int index) {
		return userdao.read(index);
	}

}
