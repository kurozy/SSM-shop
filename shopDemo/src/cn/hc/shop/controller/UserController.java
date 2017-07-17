package cn.hc.shop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.hc.shop.entities.User;
import cn.hc.shop.service.UserService;
import cn.hc.shop.utils.MailUitls;
import cn.hc.shop.utils.UUIDUtils;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("/user_exit")
	public String userExit(HttpSession session){
		
		User user = (User) session.getAttribute("existUser");
		
		if(user != null){
			session.invalidate();
		}
		
		return "redirect:/index";
	}
	
	
	@RequestMapping("/user_loginPage")
	public String userLoginPage(){
		return "login";
	}
	
	@RequestMapping("/user_login")
	public String userLogin(@RequestParam String username,@RequestParam String password,HttpSession session,Map<String,Object> map){
		
		User user = userService.login(username,password);
		
		if(user == null){
			map.put("loginFail", "用户名或密码错误，或者账户未激活");
			return "login";
		}
		
		session.setAttribute("existUser", user);
		return "redirect:/index";
	}
	
	
	@RequestMapping("/user_registPage")
	public String userRegistPage(){
		return "regist";
	}
	
	
	@ResponseBody
	@RequestMapping("/checkUsername")
	public String checkUsername(@RequestParam String username){
		System.out.println(username);
		return userService.checkUsername(username);
	}
	
	
	@RequestMapping("/user_regist")
	public ModelAndView userRegist(User user,@RequestParam("checkcode") String checkcode,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(user);
		
		String sessionCode = (String) session.getAttribute("checkCode");
		
		boolean flag = checkcode.equalsIgnoreCase(sessionCode);
		
		if(!flag){
			modelAndView.addObject("checkCodeError", "验证码错误");
			modelAndView.setViewName("regist");
			return modelAndView;
		}
		
		user.setState(0);
		user.setCode(UUIDUtils.getUUID());
		
		userService.save(user);
		
		MailUitls.sendMail(user.getEmail(), user.getCode());
		
		modelAndView.addObject("registMsg", "注册成功，请去邮箱激活！");
		modelAndView.setViewName("msg");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/user_active")
	public String userActive(@RequestParam("code") String code,Map<String,Object> map){
		
		User user = userService.queryUserByCode(code);
		if(user == null){
			map.put("activeMsg", "激活失败!用户不存在或者激活码错误");
			return "msg";
		}
		user.setState(1);
		user.setCode(null);
		
		userService.modify(user);
		
		map.put("activeMsg", "激活成功!请登录！！");
		
		return "msg";
	}
	
	
}
