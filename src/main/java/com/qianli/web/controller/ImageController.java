package com.qianli.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.Image;
import com.qianli.service.ImageService;
import com.voiweb.utils.commons.DateConverter;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;

	//上传幻灯片
	@RequestMapping(value = "/image/upload")
	public String uploadImage(ModelMap map, MultipartFile image, Image img) throws Exception {
		String path = System.getProperty("user.dir")+"/src/main/webapp/image/";
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(image.getOriginalFilename());
		String imgName = name + "." + ext;
		image.transferTo(new File(path + name + "." + ext));
		img.setIlink("../../image/" + imgName);
		img.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		imageService.save(img);
		return "redirect:/image/findAll";
	}
//修改幻灯片
	@RequestMapping(value = "/image/update")
	public String update(ModelMap map, Image img) throws MessagingException {

		return "view/adminjsp/image";
	}
//删除幻灯片
	@RequestMapping(value = "/image/delete")
	public String delete(ModelMap map, int iid) throws MessagingException {
		imageService.delete(iid);
		return "redirect:/image/findAll";
	}
//查询所有幻灯片
	@RequestMapping(value = "/image/findAll")
	public String pageList(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
			Image img) {
		Integer pageSize = 8;// 每页显示记录数
		// 分页查询
		
		PageInfo<Image> pageInfo = imageService.findAll(pn, pageSize, img);
		map.addAttribute("pageInfo", pageInfo);
		
		return "view/adminjsp/image";
	}
//前台显示幻灯片
	@RequestMapping(value = "/image/findAllToJsp")
	
	public @ResponseBody List<Image> findAllToJsp(ModelMap map) {
		/*List<Image> allImage = imageService.findAllToJsp();
		System.out.println(allImage.toString());*/
		return imageService.findAllToJsp();
	}
}
