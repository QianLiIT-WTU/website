package com.qianli.web.controller;

import java.io.File;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Users;
import com.qianli.service.BaseDictService;
import com.qianli.service.MyException;
import com.qianli.service.UserService;
import com.voiweb.utils.mail.VoiMail;

import jetbrick.util.codec.MD5Utils;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BaseDictService baseDictService;

    /*
     * 管理界面查询所有用户
     */
	
	@RequestMapping(value = "/user/findAll")
	public String userList(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
			Users user) {
		Integer pageSize = 5;// 每页显示记录数
		PageInfo<Users> pageInfo = userService.selectAll(pn, pageSize, user);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/userlist";
	}
	
	/*
	 *根据用户信息查找 
	 */

	@RequestMapping(value = "/user/findqlUser")
	public String qlList(Users user, ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
			 Integer bbid) {
		System.out.println(user.getUsername());
		Integer pageSize = 5;// 每页显示记录数
		if (bbid != null) {
			BaseDict baseDict = baseDictService.findById(bbid);
			user.setBid(baseDict);
		}
		PageInfo<Users> pageInfo = userService.selectAll(pn, pageSize, user);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/qluser";
	}
  
	/*
	 * 用户注册
	 */
	
	@RequestMapping(value = "/user/regist")
	public String regist(ModelMap map, Users user, Integer bbid, HttpSession httpSession) throws MessagingException {
		try {
			if (bbid != null) {
				user.setBid(baseDictService.findById(bbid));
			}
			
			user.setRoot(1);		
			userService.saveUser(user);	
			//httpSession.setAttribute("user", user);
			map.addAttribute("error", "请先到邮箱激活");
			return "view/login";
		} catch (Exception e) {
			if(e  instanceof MessagingException ) {	
			    map.addAttribute( "error", "邮箱账号异常，请检查邮箱账号");
			}
			
			map.addAttribute("error", e.getMessage());
			map.addAttribute("bbid", bbid);
			map.addAttribute("user", user);
			return "view/register";
		}
	}

	
	
	/*
	 * 用户删除
	 */
	

	@RequestMapping(value = "/user/deleteUser")
	public String deleteUser(ModelMap map, int uid) throws MessagingException {

		userService.delete(uid);

		return "redirect:/user/findAll";

	}
	
	/*
	 * 根据i查找
	 */
	

	@RequestMapping(value = "/user/findByUid")
	public String findByUid(ModelMap map, int uid, HttpSession httpSession) throws MessagingException {

		Users user = userService.findByUid(uid);
		httpSession.setAttribute("user", user);
		return "view/jsp/userInfo";

	}

	/*
	 * 修改用户权限
	 */
	
	@RequestMapping(value = "/user/ modifyRoot")
	public String modifyRoot(ModelMap map, Users user, HttpSession httpSession) throws MessagingException {
    Users  adminUser=(Users) httpSession.getAttribute("admin_user");
    if(adminUser.getRoot()<=user.getRoot()) {
    	map.addAttribute("msg", "您的权限不够哦");
		return "view/jsp/Msg";
    }
		try {
			userService.updateRoot(user);
			
		} catch (MyException e) {
			map.addAttribute("msg", e.getMessage());
			return "view/jsp/Msg";
		}

		return "redirect:/user/findAll";

	}

	/*
	 * 用户邮箱激活
	 */
	
	@RequestMapping(value = "/user/active")
	public String active(ModelMap map, String code) {

		try {
			userService.active(code);
			map.addAttribute("msg", "恭喜您，账号激活成功");
			return "view/jsp/Msg";
		} catch (Exception e) {
			map.addAttribute("error", e.getMessage());
			return "view/jsp/Msg";
		}
	}

	/*
	 * 用户登录
	 */
	
	@RequestMapping(value = "/user/login")
	public String login(ModelMap map, Users user, HttpSession httpSession,String  vCode) throws MessagingException {
		
		if(httpSession.getAttribute("vCode")!=null){
			
		String  scode=(String)httpSession.getAttribute("vCode");
		if(!vCode.toLowerCase().equals(scode.toLowerCase())) {
			
			map.addAttribute("error", "验证码错误");
			return "/view/login";
		}
		}
			
		try {
			Users u = userService.login(user);
			httpSession.setAttribute("user", u);
			return "redirect:/view/jsp/index.jsp";
		} catch (MyException e) {
			map.addAttribute("error", e.getMessage());
			return "/view/login";
		}
	}

	// 退出登录
	@RequestMapping(value = "/user/AClear")
	public String AClear(ModelMap map, Users user, HttpSession httpSession) throws MessagingException {

		httpSession.setAttribute("admin_user", null);
		;
		return "redirect:view/adminlogin.jsp";

	}
	/*
	 * 用户信息修改
	 */
	
	@RequestMapping(value = "/user/updateInfo")
	public String updateInfo(ModelMap map, MultipartFile photoFile, Users user) throws Exception {

		String  path=System.getProperty("user.dir");  //获取文件路径  C:\Users\涛\eclipse-ee-workspace\website
		
		
		String path1 = path+"/src/main/webapp/photo/";
		// 保存图片到
		String name = UUID.randomUUID().toString().replaceAll("-", "");

		String ext = FilenameUtils.getExtension(photoFile.getOriginalFilename());

		String photoFileName = name + "." + ext;

		photoFile.transferTo(new File(path1 + name + "." + ext));

		user.setPhotoaddress("../../photo/" + photoFileName);

		userService.updateInfo(user);
		
		return "/user/findByUid?uid=" + user.getUid();

	}

	/*
	 * 用户更改密码
	 */
	
	@RequestMapping(value = "/user/updatePsw")
	public String updatePsw(ModelMap map, Users user, String password1) {

		try {
			userService.updatePsw(user, password1);
			return "view/jsp/userInfo";
		} catch (MyException e) {

			map.addAttribute("error", e.getMessage());
			return "view/jsp/alterPsw";
		}

	}

	// 后台登录

	
	@RequestMapping(value = "/user/Alogin")
	public String Alogin(ModelMap map, Users user, HttpSession httpSession) throws MessagingException {
		try {
			Users u = userService.Alogin(user);
			httpSession.setAttribute("admin_user", u);
			return "redirect:/view/adminjsp/index.jsp";
		} catch (MyException e) {
			map.addAttribute("error", e.getMessage());
			return "view/adminlogin";
		}
	}
	
	//密码找回
	@RequestMapping(value = "/user/findPsw")
	public String findPsw(ModelMap map, Users user,HttpSession  httpSession) throws MessagingException {
		
		try {
			userService.findPsw(user);
                Users   u=userService.findUserByname(user.getUsername());
			httpSession.setAttribute("user", u);
			map.addAttribute("msg", "密码修改成功");
			
			return "view/jsp/Msg";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			map.addAttribute("error", e.getMessage());
		
			return "view/findPsw";
		}
	}
	//用户名查找问题
		@RequestMapping(value = "/user/findUser")
		public @ResponseBody   Users  findUser(ModelMap map, Users user) throws MessagingException {
			
			try {
			Users  u=	userService.findUserByname(user.getUsername());
				return  u;			
			} catch (Exception e) {
					
				return  null;
			
			}
		}

	
}
