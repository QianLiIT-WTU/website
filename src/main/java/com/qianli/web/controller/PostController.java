package com.qianli.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Comment;
import com.qianli.pojo.Message;
import com.qianli.pojo.Post;
import com.qianli.pojo.Users;
import com.qianli.service.BaseDictService;
import com.qianli.service.CommentService;
import com.qianli.service.MessageService;
import com.qianli.service.MyException;
import com.qianli.service.PostService;
import com.qianli.service.UserService;
import com.voiweb.utils.commons.DateConverter;

@Controller
public class PostController {
	
    @Autowired
	private  PostService  postservice;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
   
    @Autowired
    private BaseDictService basedictService;
	
    //所有通过审核到帖子
    @RequestMapping(value="/post/tlist")
    public String tList(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,Post post,@RequestParam(required = false)String username,Integer  bbid) throws MyException{
        Integer pageSize=5;//每页显示记录数	   
        if (username != null &&username !=" ") {
        	Users u=userService.getUserByUsername(username);
        	
        	post.setUid(u);
        } 
        if (bbid != null ) {
        	BaseDict  bd=basedictService.findById(bbid);
        	post.setBid(bd);
        } 
        PageInfo<Post> pageInfo=postservice.selectTPost(pn, pageSize,post);
        map.addAttribute("pageInfo", pageInfo);
       
        return "view/adminjsp/tpost";
    }
    //所有为通过审核的帖子
    @RequestMapping(value="/post/flist")
    public String fList(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,Post post,@RequestParam(required = false)String username,Integer  bbid) throws MyException{
        Integer pageSize=5;//每页显示记录数	   
        if (username != null &&username !="") {
        	Users u=userService.getUserByUsername(username);
        	post.setUid(u);
        } 
        if (bbid != null ) {
        	BaseDict  bd=basedictService.findById(bbid);
        	post.setBid(bd);
        } 
       
        
        PageInfo<Post> pageInfo=postservice.selectFPost(pn, pageSize,post);
      
        map.addAttribute("pageInfo", pageInfo);
        return "view/adminjsp/fpost";
    }
	 
    //前台帖子列表
    @RequestMapping(value="/post/postlist")
    	 public String postList(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,Post post,@RequestParam(required = false)String username,Integer  bbid) throws MyException{
    	        Integer pageSize=5;//每页显示记录数	   
    	        if (username != null &&username !="") {
    	        	Users u=userService.getUserByUsername(username);
    	        	post.setUid(u);
    	        } 
    	        if (bbid != null ) {
    	        	BaseDict  bd=basedictService.findById(bbid);
    	        	post.setBid(bd);
    	        } 
    	       
       
        PageInfo<Post> pageInfo=postservice.selectTPost(pn, pageSize,post);
      
        map.addAttribute("pageInfo", pageInfo);
        return "view/jsp/postList";
    }
	 //删除帖子
	 @RequestMapping(value="/post/delete")
	    public  String deleteItem(ModelMap map,int  pid){
		 postservice.deletePost(pid);			
			return "redirect:/post/tlist";    	        
	    }
	 
	 //删除我的帖子	 	
	 @RequestMapping(value="/post/mydelete", produces = "application/json; charset=utf-8")
	  @ResponseBody  public   String  deletePost(ModelMap map,int  pid){
		 postservice.deletePost(pid);	
		 String  msg="删除成功";
		
		 return msg;
			   	        
	    }
	 
	 //保存或修改帖子
	 @RequestMapping(value="/post/saveOrUpatePost")
	    public String  addPost(ModelMap map,Post post,Integer bbid) {
		
	 /* Users u=userService.findByUid(uid);
		post.setUid(u);*/
		 BaseDict  bd=basedictService.findById(bbid);
     	 post.setBid(bd);
		 post.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		 if(post.getPid()==0){
		 postservice.savePost( post);
		 map.addAttribute("msg","发布成功，待管理员审核");
		 return  "view/jsp/Msg";
		 }
		 else {
			 postservice.update(post);
			 return "redirect:/post/postlist";    
		 }
			  
	    }
	
    //帖子详情
	 @RequestMapping(value="/post/Info")
	    public String  Info(ModelMap map,int pid) {
		Post post=postservice.findByPid(pid);
		post.setClick(post.getClick()+1);
		postservice.UpdateClick(post);
		 map.addAttribute("post", post);
		
	        return "view/jsp/postDetail";    
	    }
	 //查询帖子
	 @RequestMapping(value="/post/findPost")
	    public String  findPost(ModelMap map,Integer pid) {
		Post post=postservice.findByPid(pid);
	
		 map.addAttribute("post", post);
		 
	        return "view/adminjsp/postDetail";    
	    }
	 
   //查找帖子跳转到编辑页面
	 @RequestMapping(value="/post/edit")
	    public String  editPost(ModelMap map,Integer pid) {
		Post post=postservice.findByPid(pid);
	
		 map.addAttribute("post", post);
		 
	        return "view/jsp/newPost";    
	    }
	 
	 
	//过审帖子
	 @RequestMapping(value="/post/updateStatus")
	    public String  UpdateStatus(ModelMap map,Post post) {
		 
		postservice.updateStatus( post);
		Post p=postservice.findByPid(post.getPid());
		 Message  message=new  Message();
		 message.setTitle("帖子审核");
		 message.setTouser(String.valueOf(p.getUid().getUid()));
		 if(post.isStatus()) 
			message.setContent("帖子通过审核");
		 else
			 message.setContent("帖子未通过审核");
		message.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		 messageService.save(message);
		return "redirect:/post/flist";    
	    }
	 //我的帖子
	 @RequestMapping(value="/post/mypost")
	    public String findMyPost(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,int uid){
	        Integer pageSize=5;//每页显示记录数	  
	      
	        PageInfo<Post> pageInfo=postservice.findMyPost(pn, pageSize,uid);
	  
	        map.addAttribute("pageInfo", pageInfo);
	        return "view/jsp/myPost";
	    }
	 //热门帖子
	 @RequestMapping(value="/post/hotpost")
	    public @ResponseBody String hotPost(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
	        Integer pageSize=8;//每页显示记录数	  
	      
	        PageInfo<Post> pageInfo=postservice.findHotPost(pn, pageSize);
	  
	       // map.addAttribute("pageInfo", pageInfo);
	        return pageInfo.toString();
	    }
}
