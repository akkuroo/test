package net.kkuru.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Simple User CRUD Controller
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * Simple User List
	 */
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String list(Model model) {
		
		List<User> users = userDao.findList();
		model.addAttribute("list", users);
		
		return "user/list";
	}

	/**
	 * Simply User Create
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "user/create";
	}

	/**
	 * Simply User Do Create
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String doCreate(@RequestParam(value = "name") String name) {
		userDao.create(userDao.getMaxIdx()+1, name);
		return "redirect:list";
	}
	
	/**
	 * Simply User Delete
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "name") String name) {
		userDao.deleteByName(name);
		return "redirect:list";
	}
}
