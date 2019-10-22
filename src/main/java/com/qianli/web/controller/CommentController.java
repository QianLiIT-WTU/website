package com.qianli.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianli.pojo.Comment;
import com.qianli.pojo.Post;
import com.qianli.service.CommentService;
import com.qianli.service.MyException;
import com.qianli.service.PostService;
import com.qianli.service.SourceService;
import com.qianli.service.UserService;
import com.voiweb.utils.commons.DateConverter;

@Controller
public class CommentController {
	@Autowired
	private CommentService conmmentservice;
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postservice;
	@Autowired
	private SourceService sourceservice;

	//保存分类
	@RequestMapping(value = "/conmment/Psavecomment")
	@ResponseBody
	public List<Comment> addPost(Comment comment, Integer uuid, Integer ppid) {
		comment.setPid(postservice.findByPid(ppid));
		comment.setUid(userService.getUserByUid(uuid));
        
		
		comment.setCcreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		conmmentservice.saveComment(comment);

		
		return findByPid(ppid);
	}

	//资源评论
	@RequestMapping(value = "/conmment/Ssavecomment")
	@ResponseBody
	public List<Comment> addSource(String ccontent, Integer uuid, Integer sid) throws MyException {
	Comment comment=new Comment();
	comment.setCcontent(ccontent);
		comment.setSid(sourceservice.getSourceById(sid));
		comment.setUid(userService.getUserByUid(uuid));
        
		
		comment.setCcreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		conmmentservice.saveComment(comment);

		
		return findBySid(sid);
	}
	//根据资源查询评论
	public List<Comment> findBySid(Integer sid) {
		List<Comment> comtentList = conmmentservice.findBySid(sid);
		for (Comment comment : comtentList) {
			System.out.println(comment.toString());
		}
		
		return comtentList;
	}
	//帖子查询评论
	public List<Comment> findByPid(Integer ppid) {
		List<Comment> comtentList = conmmentservice.findByPid(ppid);
		
		return comtentList;
	}

}
