package com.qianli.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Message;
import com.qianli.pojo.Flag;
import com.qianli.pojo.Users;
import com.qianli.service.FlagService;
import com.qianli.service.MyException;
import com.qianli.service.UserService;
import com.voiweb.utils.commons.DateConverter;

@Controller
public class FlagCntroller {
	@Autowired
	private  FlagService   flagService;
	@Autowired
	private  UserService   userService;
	
	//公告消息
	 @RequestMapping(value="/flag/AnnunceList")
	public String  AnnunceList(ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,int uid){
        Integer pageSize=5;//每页显示记录数	  
      
        PageInfo<Message> pageInfo=flagService.	MessageList(pn, pageSize, uid);   
       
        map.addAttribute("pageInfo", pageInfo);
        return "view/jsp/userMsg";
    }
	 //删除消息
	 @RequestMapping(value="/flag/delete")
	public String  delete(ModelMap map,Integer   fid,Integer  uid){
      
		
       flagService.delete(fid);
       return "redirect:/flag/AnnunceList?uid="+uid;
    }
	 
	//更改消息状态
	 @RequestMapping(value="/flag/updateStatus")
		public String  updateStatus(ModelMap map,Integer   fid,Integer  uid){
	      Flag  flag=flagService.getById(fid);
		
	      flag.setReadtime(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
	
	       try {
			flagService.updateStatus(flag);
			 
		} catch (MyException e) {
			map.addAttribute("msg",e.getMessage());
			 return "view/jsp/Msg";
		}
	       return "redirect:/flag/AnnunceList?uid="+uid;
	    }
		 
}
