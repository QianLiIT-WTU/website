/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-22 04:29:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/login.css\" rel=\"stylesheet\">\r\n");
      out.write("<title>千里IT-登录</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"nav-simple\">\r\n");
      out.write("\t\t<div class=\"login-wrapper\">\r\n");
      out.write("\t\t\t<div class=\"logo\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login-center-wrap\">\r\n");
      out.write("\t\t<div class=\"login-wrapper\">\r\n");
      out.write("\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login\" id=\"login-form\" class=\"login\" method=\"post\">\r\n");
      out.write("\t\t\t\t<div class=\"user-con\">\r\n");
      out.write("\t\t\t\t\t<div class=\"user-title\">用户登录</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"user-box\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"error-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-minus-circle error-icon\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"error-msg\" id=\"cue\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">用户名 </label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"username\" onkeyup=\"this.value=this.value.replace(/\\s+/g,'')\" type=\"text\" placeholder=\"请输入用户名\" autocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"user-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<label class=\"user-label\">密码</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"user-content\" name=\"password\" onkeyup=\"this.value=this.value.replace(/\\s+/g,'').replace(/[\\u4e00-\\u9fa5]/g, '')\" type=\"password\" placeholder=\"请输入密码\"\r\n");
      out.write("\t\t\t\t\t\t\t\tautocomplete=\"off\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"img\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/vcode\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("                                     <input class=\"user-content\" type=\"text\" name=\"vCode\" \r\n");
      out.write("                                     placeholder=\"请输入验证码\"  />\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-submit\" onclick=\"check()\">登录</button>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"link-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/view/findPsw.jsp\" target=\"_self\">找回密码</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/view/register.jsp\" target=\"_self\">点此注册</a>\r\n");
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
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t//获取表单、错误提示、字段\r\n");
      out.write("\t\tlet loginForm = document.getElementById(\"login-form\");\r\n");
      out.write("\t\tlet cue = document.getElementById(\"cue\");\r\n");
      out.write("\t\tlet usr = document.getElementsByName(\"username\")[0];\r\n");
      out.write("\t\tlet psw = document.getElementsByName(\"password\")[0];\r\n");
      out.write("\r\n");
      out.write("\t\tif (cue.innerText) {\r\n");
      out.write("\t\t\tcue.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkUsr(value) {\r\n");
      out.write("\t\t\tif (value) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tcue.innerText = \"请输入用户名\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkPsw(value) {\r\n");
      out.write("\t\t\tif (value) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tcue.innerText = \"请输入密码\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction check() {\r\n");
      out.write("\t\t\tcue.parentNode.style.display = \"block\";\r\n");
      out.write("\t\t\tif (checkUsr(usr.value) && checkPsw(psw.value)) {\r\n");
      out.write("\t\t\t\tcue.parentNode.style.display = \"none\";\r\n");
      out.write("\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"wrapper\">\r\n");
      out.write("        <div class=\"login-con\">\r\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login\" class=\"login\" method=\"post\">\r\n");
      out.write("                <h1 class=\"title\">用户登录</h1>\r\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"用户名\"><br>\r\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"密码\"><br>\r\n");
      out.write("                <input type=\"submit\" value=\"登录\">\r\n");
      out.write("            </form>\r\n");
      out.write("            <div class=\"register-link\"><a href=\"register.jsp\">没有账号？点此注册</a></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("<h2 align=\"center\"  style=\"color:red\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h2>\r\n");
      out.write("    <script src=\"https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("-->\r\n");
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
