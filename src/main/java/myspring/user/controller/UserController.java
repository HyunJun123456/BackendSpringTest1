package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	public UserController() {
		System.out.println(this.getClass().getName()+" 생성자 호출됨");
		// 두번 호출됨 (설정에서 두번 넣어줘서)
		// Presentation Layer에 필요한 설정을 따로 만들어줘야함
	}

	@RequestMapping("/userList.do") // 디스페쳐 서블릿이 알아서 컨트롤러를 불러줌
	public ModelAndView userList() {
		List<UserVO> userVOList = userService.getUserList();
		// jsp 페이지 이름 / 페이지에서 불러올 이름(키값) / 넣어줄 데이터
		// ModelAndView(String viewName, String modelName, Object modelObject)
		return new ModelAndView("userList", "userList", userVOList);
	}
	
	@RequestMapping("/getUser.do")
	public String getUser(@RequestParam("id") String userId, Model model) {
		UserVO userVO = userService.getUser(userId);
		model.addAttribute("user", userVO);
		return "userInfo";
	}
	
}
