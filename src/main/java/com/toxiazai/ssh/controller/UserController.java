package com.toxiazai.ssh.controller;

import com.toxiazai.ssh.entity.SysUser;
import com.toxiazai.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author Judas.n 2014年4月6日 22:48:22
 */
@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public String index() {
		return "/views/hello";
	}

	/**
	 * 查询用户
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public ModelAndView getUser(String id,
						  HttpServletRequest request) {
		SysUser sysUser = userService.getUser(id);
		request.setAttribute("sysUser", sysUser);
		request.setAttribute("msg", "查询成功");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("user", sysUser);
		return mv;
	}

	/**查询列表
	 *
	 */
	@RequestMapping(value = "gets", method = RequestMethod.GET)
	public String gets(HttpServletRequest request) {
		SysUser user = new SysUser();
		user.setUserId("2");
		user.setUserName("Test");
		request.setAttribute("sysUser", user);
		request.setAttribute("msg", "查询成功");
		return "result";
	}

	/**JsonTest
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "json")
	public SysUser json() {
		SysUser user = new SysUser();
		user.setUserId("2");
		user.setUserName("Test");
		return user;
	}

	/**
	 * 增加用户
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveUser(String name,
						   HttpServletRequest request) {
		SysUser sysUser = new SysUser();
		sysUser.setUserId(UUID.randomUUID().toString());
		sysUser.setUserName(name);
		userService.saveUser(sysUser);
		request.setAttribute("sysUser", sysUser);
		request.setAttribute("msg", "添加成功");
		return "result";
	}

}
