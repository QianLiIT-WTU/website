package com.qianli.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Message;
import com.qianli.pojo.QueryVo;
import com.qianli.pojo.Users;
import com.qianli.service.MessageService;
import com.qianli.service.UserService;
import com.voiweb.utils.commons.DateConverter;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	//发布公告
	@RequestMapping(value = "/announce/save")
	public String saveAnnounce(Message message, ModelMap map) {
		message.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		messageService.save(message);
		QueryVo vo = new QueryVo();
		vo.setUserlist(userService.findAll());
		vo.setMid(message.getMid());
		messageService.relase(vo);

		return "redirect:/announce/find";

	}
    //查询公告
	@RequestMapping(value = "/announce/find")
	public String findMessage(String title, Integer mid, ModelMap map,

			@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
		Integer pageSize = 5;// 每页显示记录数
		Message message = new Message();
		if (title != null & title != "") {
			message.setTitle(title);
		}
		if (mid != null) {
			message.setMid(mid);
			;
		}
		PageInfo<Message> pageInfo = messageService.selectAll(pn, pageSize, message);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/announcement";
	}

//删除公告
	@RequestMapping(value = "/announce/delete")
	public String deleteAnnounce(int mid) {
		messageService.updateStatus(mid);

		return "redirect:/announce/find";
	}
 //查找公告
	@RequestMapping(value = "/announce/findByUid")
	public String findByUid(int uid, ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
		Integer pageSize = 5;// 每页显示记录数

		PageInfo<Message> pageInfo = messageService.findByUid(pn, pageSize, uid);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/announcement";
	}

	//保存信息
	@RequestMapping(value = "/message/save")
	@ResponseBody
	public String saveMessage(@RequestBody Message message, ModelMap map) {
		message.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		messageService.save(message);
		Users user = userService.getUserByUid(Integer.parseInt(message.getTouser()));
		List<Users> uList = new ArrayList<>();
		uList.add(user);
		QueryVo vo = new QueryVo();
		vo.setUserlist(uList);
		vo.setMid(message.getMid());
		messageService.relase(vo);

		return "发送成功";

	}
}
