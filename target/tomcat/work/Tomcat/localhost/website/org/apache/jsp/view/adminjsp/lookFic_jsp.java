/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-02-24 01:41:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.adminjsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lookFic_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/reset.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/postDetail.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.4.4.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/css/layui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/font.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/style.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write(".view-img {\r\n");
      out.write("\twidth: 800px;\r\n");
      out.write("\tmargin: 40px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".img-con img {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".img-info {\r\n");
      out.write("\twidth: 400px;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("\tcolor: #777;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".download-img {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 140px;\r\n");
      out.write("\theight: 36px;\r\n");
      out.write("\tline-height: 36px;\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("\tborder-radius: 10px;\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\ttransition: 0.2s all linear;\r\n");
      out.write("\tbackground: #5991d4;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".download-img:hover {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tbox-shadow: #d8dde1 2px 4px 8px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>千里IT-资源列表</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#sent\").click(function() {\r\n");
      out.write("\t\t\tvar options = {\r\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/conmment/Ssavecomment',\r\n");
      out.write("\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\tdataType : \"json\",//预期服务器返回的数据类型\r\n");
      out.write("\t\t\t\tdata : $(\"#saveComment\").serialize(),\r\n");
      out.write("\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\talert(\"发布成功\");\r\n");
      out.write("\t\t\t\t\tlocation.reload();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\talert(\"发布失败\");\r\n");
      out.write("\t\t\t\t\tlocation.reload();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t$.ajax(options);\r\n");
      out.write("\t\t\t$(\"#content\").text(\" \");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<body class=\"layui-layout-body\">\r\n");
      out.write("\t<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminHeader.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<div class=\"view-img\">\r\n");
      out.write("\t\t\t<div class=\"img-con\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.slink }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"img-info\">\r\n");
      out.write("\t\t\t\t<p>标题：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.sname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" 上传者：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.uid.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t<p>介绍：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.info }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<a class=\"download-img\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/source/downloadFic?sid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.sid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">下载</a>\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-sm\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/source/updateFStatus?sid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&status=1\">\r\n");
      out.write("\t\t\t\t<span id=\"T\">过审</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-sm\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/source/updateFStatus?sid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&status=0\">\r\n");
      out.write("\t\t\t\t<span id=\"F\">不过审</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- \t<div class=\"view-img\"> -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<!-- \t\t<div class=\"img-con\"> -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<!-- \t\t</div> -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<!-- \t</div> -->\r\n");
      out.write("\t\t<!--  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js\"></script>\r\n");
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
