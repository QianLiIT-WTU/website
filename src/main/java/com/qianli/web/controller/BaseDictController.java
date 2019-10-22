package com.qianli.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Users;
import com.qianli.service.BaseDictService;
import com.qianli.service.MyException;

@Controller
public class BaseDictController {
	
	@Autowired
	private BaseDictService basedictServise;
	
	//根据id查询分类
	@RequestMapping(value ="/basedict/findBycode")
	@ResponseBody
	public  List<BaseDict>  items( Integer   dict_type_code ){
		
		List<BaseDict>  items=basedictServise.findBycode(dict_type_code);
		      
	     
		  return items;
		
	
	}
	
	
	//分类列表
	 @RequestMapping(value="/basedict/list")
    public String qlList(BaseDict basedict ,ModelMap map,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn){
        Integer pageSize=5;//每页显示记录数	    
       
        PageInfo<BaseDict> pageInfo=basedictServise.selectAll(pn, pageSize,basedict);
        map.addAttribute("pageInfo", pageInfo);
        return "view/adminjsp/catego";
    }
	 
	 //删除分类
	 @RequestMapping(value="/basedict/deleteItem")
	    public String deleteItem(ModelMap map,int  bid){
		 basedictServise.unenable(bid);			
			return "redirect:/basedict/list";
     
	        
	    }
	 	 //编辑分类
	 @RequestMapping(value="/basedict/editItem")
	    public String  toedit(ModelMap map,int bid){
		    BaseDict basedict=basedictServise.findById(bid)	;		
		 map.addAttribute("basedict", basedict);
	        return "view/adminjsp/addCatego";  
	    }
	 
	 //保存或更新分类
	 @RequestMapping(value="/basedict/saveOrUpdate")
	    public String  addItem(ModelMap map,BaseDict  basedict){
		 try {
			 
			basedictServise.saveOrUpdateItem( basedict);
		
		} catch (MyException e) {
			map.addAttribute("error", e.getMessage());
	        return "view/adminjsp/addCatego"; 
		}			
			return "redirect:/basedict/list";      
	    }
	 
}
