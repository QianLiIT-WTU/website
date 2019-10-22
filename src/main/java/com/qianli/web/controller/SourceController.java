package com.qianli.web.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.qianli.pojo.BaseDict;
import com.qianli.pojo.Image;
import com.qianli.pojo.Message;
import com.qianli.pojo.Post;
import com.qianli.pojo.Source;
import com.qianli.pojo.Users;
import com.qianli.service.BaseDictService;
import com.qianli.service.MessageService;
import com.qianli.service.MyException;
import com.qianli.service.SourceService;
import com.qianli.service.UserService;
import com.voiweb.utils.commons.DateConverter;

@Controller
public class SourceController {
	@Autowired
	private SourceService sourceService;
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private UserService userService;
	 @Autowired
	    private MessageService messageService;
	 
	 
		/*
		 * 资源部分——上传图片
		 */
		
	@RequestMapping(value = "/source/uploadPicture")
	public String uploadSource(ModelMap map, MultipartFile picture, Source source, int bbid, int uuid) throws Exception {

		// String path=System.getProperty("user.dir"); //获取文件路径
		// C:\Users\涛\eclipse-ee-workspace\website

		String path = System.getProperty("user.dir") + "/src/main/webapp/source/picture/";
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(picture.getOriginalFilename());
		String sname = name + "." + ext;
		picture.transferTo(new File(path + name + "." + ext));
		source.setSlink("source/picture/" + sname);
		source.setVideoImg("source/picture/" + sname);
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUid(uuid);
		source.setUid(users);
		source.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		sourceService.save(source);
		map.addAttribute("msg", "上传成功,等待管理员审核");
		return "view/jsp/Msg";
	}
	/*
	 * 资源部分——上传文件
	 */
	
	@RequestMapping(value = "/source/uploadFile")
	public String uploadFole(ModelMap map, MultipartFile file, Source source, int bbid, int uuid) throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/webapp/source/file/";
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		String sname = name + "." + ext;
		file.transferTo(new File(path + name + "." + ext));
		source.setSlink("source/file/" + sname);
		source.setVideoImg("img/file_icon.jpg");
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUid(uuid);
		source.setUid(users);
		source.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		sourceService.save(source);
		map.addAttribute("msg", "上传成功,等待管理员审核");
		return "view/jsp/Msg";
	}

	/*
	 * 资源部分——前台查询图片
	 */
	
	@RequestMapping(value = "/source/getPicture")
	public String getAllPic(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source, Integer bbid, String username)
			throws Exception {
		Integer pageSize = 5;// 每页显示记录数
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUsername(username);
		source.setUid(users);
		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/jsp/picList";
	}
	/*
	 * 资源部分——后台查看所有图片
	 */
	
	@RequestMapping(value = "/source/getToAdminPicture")
	public String getToAdminPicture(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source,
			@RequestParam(required = false, defaultValue = "6", value = "bbid") Integer bbid, String username) throws Exception {
		Integer pageSize = 5;// 每页显示记录数
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUsername(username);
		source.setUid(users);
		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/Psource";
	}

	/*
	 * 资源部分——后台查看文件
	 */
	
	@RequestMapping(value = "/source/getToAdminFile")
	public String getAllPicToAdmFile(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source,
			@RequestParam(required = false, defaultValue = "8", value = "bbid") Integer bbid, String username) throws Exception {
		Integer pageSize = 5;// 每页显示记录数
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUsername(username);
		source.setUid(users);
		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/Fsource";
	}

	/*
	 * 资源部分———后台查看所有视频
	 */
	
	@RequestMapping(value = "/source/getToAdminVideo")
	public String getAllPicToAdmVideo(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source,
			@RequestParam(required = false, defaultValue = "7", value = "bbid") Integer bbid, String username) throws Exception {
		Integer pageSize = 5;// 每页显示记录数
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUsername(username);
		source.setUid(users);
		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/adminjsp/Vsource";
	}
 
	/*
	 * 资源部分———查看图片
	 */
	@RequestMapping(value = "/source/lookPic")
	public String getSourceById(ModelMap map, int sid) throws Exception {
		Source source = sourceService.getSourceById(sid);
	
		map.addAttribute("source", source);
		return "view/jsp/lookPic";
	}
	/*
	 * 资源部分———查看文件
	 */
	@RequestMapping(value = "/source/lookFile")
	public String getSourceByFId(ModelMap map, int sid) throws Exception {
		Source source = sourceService.getSourceById(sid);
		map.addAttribute("source", source);
		return "view/jsp/lookFic";
	}
	/*
	 * 资源部分———下载图片
	 */
	@RequestMapping(value = "/source/downloadPic")
	public ResponseEntity<byte[]> downloadPic(int sid) throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/webapp/source/picture/";
		Source pic = sourceService.getSourceById(sid);
		String getPicName = (pic.getSlink()).split("/")[2];
		File picFile = new File(path + getPicName);
		String picName = new String(getPicName.getBytes("UTF-8"), "iso8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", picName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(picFile), headers, HttpStatus.CREATED);
	}
	/*
	 * 资源部分———下载文件
	 */
	@RequestMapping(value = "/source/downloadFic")
	public ResponseEntity<byte[]> downloadFic(int sid) throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/webapp/file/";
		Source pic = sourceService.getSourceById(sid);
		String getFileName = (pic.getSlink()).split("/")[2];
		File picFile = new File(path + getFileName);
		if(picFile.exists()) {
		String FName = new String(getFileName.getBytes("UTF-8"), "iso8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", FName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(picFile), headers, HttpStatus.CREATED);
		}else {
			return  null;
		}
		}
	/*
	 * 资源部分———下载文件
	 */
	@RequestMapping(value = "/source/downloadVic")
	public ResponseEntity<byte[]> downloadVic(int sid) throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/webapp/source/video/";
		Source video= sourceService.getSourceById(sid);
		String getFileName = (video.getSlink()).split("/")[2];
		File videoFile = new File(path + getFileName);
		if(videoFile.exists()) {
		String FName = new String(getFileName.getBytes("UTF-8"), "iso8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", FName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(videoFile), headers, HttpStatus.CREATED);
		}else {
			return  null;
		}
		}
	/*
	 * 资源部分———上传视频
	 */
	@RequestMapping(value = "/source/uploadVideo")
	public String uploadSourceVideo(ModelMap map, MultipartFile video, MultipartFile videoImage, Source source, int bbid, int uuid) throws Exception {
		String videoPath = System.getProperty("user.dir") + "/src/main/webapp/source/video/";
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(video.getOriginalFilename());
		String sname = name + "." + ext;
		video.transferTo(new File(videoPath + name + "." + ext));
		source.setSlink("source/video/" + sname);
		String videoImgPath = System.getProperty("user.dir") + "/src/main/webapp/source/video/videoImg/";
		String nameImg = UUID.randomUUID().toString().replaceAll("-", "");
		String extImg = FilenameUtils.getExtension(videoImage.getOriginalFilename());
		String snameImg = nameImg + "." + extImg;
		videoImage.transferTo(new File(videoImgPath + nameImg + "." + extImg));
		source.setVideoImg("source/video/videoImg/" + snameImg);
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		Users users = userService.getUserByUid(uuid);
		source.setUid(users);
		source.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		sourceService.save(source);
		map.addAttribute("msg", "上传成功,等待管理员审核");
		return "view/jsp/Msg";
	}
	/*
	 * 资源部分———前台显示视频
	 */
	@RequestMapping(value = "/source/getVideo")
	public String getAllVid(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source, Integer bbid) {
		Integer pageSize = 5;// 每页显示记录数
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/jsp/vidList";
	}
	/*
	 * 资源部分———查看视频
	 */
	@RequestMapping(value = "/source/lookVid")
	public String getVidSourceById(ModelMap map, int sid) throws Exception {
		Source source = sourceService.getSourceById(sid);
		map.addAttribute("source", source);
		return "view/jsp/course";
		// return "redirect:/source/getVideoToCource?bbid="+vid.getBid().getBid();
	}
     //得到视频资源
	@RequestMapping(value = "/source/getVideoToCource")
	public String getAllVidToCource(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source, Integer bbid) {
		Integer pageSize = 5;// 每页显示记录数
		BaseDict baseDict = baseDictService.findById(bbid);
		source.setBid(baseDict);
		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/jsp/course";
	}
   //删除图片
	@RequestMapping(value = "/source/Pdelete")
	public String Pdelete(ModelMap map, Integer sid) {
		sourceService.delete(sid);
		return "redirect:/source/getToAdminPicture";
	}
	//删除文件资源
	@RequestMapping(value = "/source/Fdelete")
	public String Fdelete(ModelMap map, Integer sid) {
		sourceService.delete(sid);
		return "redirect:/source/getToAdminFile";
	}
	//删除视频资源
	@RequestMapping(value = "/source/Vdelete")
	public String Vdelete(ModelMap map, Integer sid) {
		sourceService.delete(sid);
		return "redirect:/source/getToAdminVideo";
	}
    
	//前台显示所有通过审核到资源
	@RequestMapping(value = "/source/getAllSource")
	public String getAllSource(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Source source,
			@RequestParam(required = false, defaultValue = "6", value = "bbid") Integer bbid, String username) throws Exception {
		Integer pageSize = 12;// 每页显示记录数

		BaseDict baseDict = baseDictService.findById(bbid);

		source.setBid(baseDict);
		Users users = userService.getUserByUsername(username);
		source.setUid(users);

		PageInfo<Source> pageInfo = sourceService.findAll(pn, pageSize, source);
		map.addAttribute("pageInfo", pageInfo);
		return "view/jsp/source";
	}
	//修改资源
	@RequestMapping(value = "/source/updateStatus")
	public String updateStatus(ModelMap map, Source source) {
		sourceService.updateStatus(source);
		return "redirect:/source/getToAdmin";
	}

	//首页热门资源
	@RequestMapping(value = "/source/getHotSource")
	@ResponseBody
	public PageInfo<Source> getVideoToIndex(ModelMap map, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn)
			throws Exception {
		Integer pageSize = 8;// 每页显示记录数

		/*Users users = userService.getUserByUsername(username);
		source.setUid(users);*/
		PageInfo<Source> pageInfo = sourceService.getHotSource(pn, pageSize);
		
		return pageInfo;
	
	}
	//后台审核文件资源
	 @RequestMapping(value="/source/updateFStatus")
    public String  FUpdateStatus(ModelMap map,Source source)  {
	
		 sourceService.updateStatus( source);
		 Source s=sourceService.getSourceById(source.getSid());
	 Message  message=new  Message();
	 message.setTitle("资源审核");
	 message.setTouser(String.valueOf(s.getUid().getUid()));
	 if(source.isStatus()) 
		message.setContent("资源通过审核");
	 else
		 message.setContent("资源未通过审核");
	message.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
	 messageService.save(message);
	 
	
	
		 return  "redirect:/source/getToAdminFile";
	
    }
	//后台审核图片文件
	 @RequestMapping(value="/source/PupdatePStatus")
	    public String  PUpdateStatus(ModelMap map,Source source)  {
		
			 sourceService.updateStatus( source);
			 Source s=sourceService.getSourceById(source.getSid());
		 Message  message=new  Message();
		 message.setTitle("资源审核");
		 message.setTouser(String.valueOf(s.getUid().getUid()));
		 if(source.isStatus()) 
			message.setContent("资源通过审核");
		 else
			 message.setContent("资源未通过审核");
		message.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
		 messageService.save(message);
	 
		
			 return  "redirect:/source/getToAdminPicture";
		
	    }
	//后台审核视频资源
		 @RequestMapping(value="/source/VupdateVStatus")
		    public String  VUpdateStatus(ModelMap map,Source source)  {
			
				 sourceService.updateStatus( source);
				 Source s=sourceService.getSourceById(source.getSid());
			 Message  message=new  Message();
			 message.setTitle("资源审核");
			 message.setTouser(String.valueOf(s.getUid().getUid()));
			 if(source.isStatus()) 
				message.setContent("资源通过审核");
			 else
				 message.setContent("资源未通过审核");
			message.setCreate_time(DateConverter.today("yyyy-MM-dd HH:mm:ss"));
			 messageService.save(message);
			
			
				 return  "redirect:/source/getToAdminVideo";
			
		    }
		//后台查看图片
		@RequestMapping(value = "/source/AlookPic")
		public String AgetSourceById(ModelMap map, int sid) throws Exception {
			Source source = sourceService.getSourceById(sid);
		
			map.addAttribute("source", source);
			return "view/adminjsp/lookPic";
		}
		//后台查看文件
		@RequestMapping(value = "/source/AlookFile")
		public String AgetSourceByFId(ModelMap map, int sid) throws Exception {
			Source source = sourceService.getSourceById(sid);
			map.addAttribute("source", source);
			return "view/adminjsp/lookFic";
		}
		//后台查看视频
		@RequestMapping(value = "/source/AlookVid")
		public String AgetVidSourceById(ModelMap map, int sid) throws Exception {
			Source source = sourceService.getSourceById(sid);
			map.addAttribute("source", source);
			return "view/adminjsp/course";
			// return "redirect:/source/getVideoToCource?bbid="+vid.getBid().getBid();
		}
}
