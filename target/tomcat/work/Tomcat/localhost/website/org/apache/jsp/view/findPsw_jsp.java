/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-22 03:32:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class findPsw_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/login.css\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write(".hidden {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>千里IT-找回密码</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"nav-simple\">\r\n");
      out.write("\t\t<div class=\"login-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"logo\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"register-center-wrap\">\r\n");
      out.write("\t\t<div class=\"login-wrapper\">\r\n");
      out.write("\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/findPsw\" id=\"register-form\" class=\"register\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div class=\"user-con\">\r\n");
      out.write("\t\t\t\t\t<div class=\"user-title\">找回密码</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"user-box\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"error-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-minus-circle error-icon\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"error-msg\" id=\"cue\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">用户名</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"username\" onkeyup=\"this.value=this.value.replace(/\\s+/g,'')\" type=\"text\" placeholder=\"请输入用户名\" autocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-submit\" id=\"username-btn\" onclick=\"getQuestion()\">确定</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">新密码</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"password\" onkeyup=\"this.value=this.value.replace(/\\s+/g,'').replace(/[\\u4e00-\\u9fa5]/g, '')\" type=\"password\" placeholder=\"请输入密码\"\r\n");
      out.write("\t\t\t\t\t\t\t\tautocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">确认密码</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"password-confirm\" onkeyup=\"this.value=this.value.replace(/\\s+/g,'').replace(/[\\u4e00-\\u9fa5]/g, '')\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"请再次输入密码以确认\" autocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">问题</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"question\" disabled onkeyup=\"this.value=this.value.replace(/\\s+/g,'')\" type=\"text\" autocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">答案</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"answer\" onkeyup=\"this.value=this.value.replace(/\\s+/g,'')\" type=\"password\" placeholder=\"请输入找回密码答案\" autocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-submit hidden\" id=\"alter-psw-btn\" onclick=\"check()\">重置密码</button>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"link-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/view/login.jsp\" target=\"_self\">点此登录</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"footer\">\r\n");
      out.write("\t\t<div class=\"login-wrappper\">\r\n");
      out.write("\t\t\t<div class=\"links\">\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"link\">论坛</a>\r\n");
      out.write("\t\t\t\t|\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"link\">图文</a>\r\n");
      out.write("\t\t\t\t|\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"link\">视频</a>\r\n");
      out.write("\t\t\t\t|\r\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"link\">教程</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p class=\"copyright\">千里之行，始于足下。</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t//loadSelect(\"1\",\"useritem\",\"dict_item.dict_id\", <s:if test=\"#user.dict_item!=null\">,<s:property value=\"#user.dict_item.dict_id\" /></s:if>);\r\n");
      out.write("\t\t\tloadSelect(\"1\", \"useritem\", \"bbid\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t//获取表单、错误提示、字段\r\n");
      out.write("\t\tlet registerForm = document.getElementById(\"register-form\");\r\n");
      out.write("\t\tlet cue = document.getElementById(\"cue\");\r\n");
      out.write("\t\tlet usr = document.getElementsByName(\"username\")[0];\r\n");
      out.write("\t\tlet psw = document.getElementsByName(\"password\")[0];\r\n");
      out.write("\t\tlet psw2 = document.getElementsByName(\"password-confirm\")[0];\r\n");
      out.write("\t\tlet question = document.getElementsByName(\"question\")[0];\r\n");
      out.write("\t\tlet answer = document.getElementsByName(\"answer\")[0];\r\n");
      out.write("\t\tlet usernameBtn = document.getElementById(\"username-btn\");\r\n");
      out.write("\t\tlet alterPswBtn = document.getElementById(\"alter-psw-btn\");\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkUsr(value) {\r\n");
      out.write("\t\t\tif (value) {\r\n");
      out.write("\t\t\t\tif (value.length < 3) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"用户名至少为3个字符\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else if (value.length > 10) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"用户名至多为10个字符\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tcue.innerText = \"请输入用户名\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkPsw(value) {\r\n");
      out.write("\t\t\tif (value) {\r\n");
      out.write("\t\t\t\tif (value.length < 6) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"密码至少为6个字符\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else if (value.length > 20) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"密码至多为20个字符\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else if (!/[^\\d]/g.test(value)) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"密码不能全为数字\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else if (!/[^a-zA-Z]/g.test(value)) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"密码不能全为字母\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tcue.innerText = \"请输入密码\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction confirmPsw(value) {\r\n");
      out.write("\t\t\tif (value) {\r\n");
      out.write("\t\t\t\tif (value !== psw.value) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"两次输入的密码不一致\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tcue.innerText = \"请确认密码\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkAnswer(value) {\r\n");
      out.write("\t\t\tif (value) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tcue.innerText = \"请输入找回密码答案\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction check() {\r\n");
      out.write("\t\t\tcue.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\tif (checkUsr(usr.value) && checkPsw(psw.value) && confirmPsw(psw2.value) && checkAnswer(answer.value)) {\r\n");
      out.write("\t\t\t\tcue.parentNode.style.display = \"none\";\r\n");
      out.write("\t\t\t\tregisterForm.submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction getQuestion() {\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/findUser\", {\r\n");
      out.write("\t\t\t\tusername : usr.value\r\n");
      out.write("\t\t\t}, function(data) {\r\n");
      out.write("\t\t\t\tif (data === null) {\r\n");
      out.write("\t\t\t\t\tcue.innerText = \"该用户不存在\";\r\n");
      out.write("\t\t\t\t\tcue.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tcue.parentNode.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\tquestion.value = data.question;\r\n");
      out.write("\t\t\t\t\tusr.parentNode.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\tusernameBtn.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\tpsw.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\t\t\tpsw2.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\t\t\tquestion.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\t\t\tanswer.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\t\t\talterPswBtn.style.display = \"block\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, \"json\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
