/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-03-11 02:30:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springSSLEx01/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springSSLEx01/WEB-INF/lib/jstl-1.2.jar!/META-INF/x.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springSSLEx01/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springSSLEx01/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/springSSLEx01/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1644909417825L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("   \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta id=\"_csrf\" name=\"_csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"\r\n");
      out.write("	  integrity=\"sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p\"\r\n");
      out.write("	  crossorigin=\"anonymous\"/>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<title>회원가입창</title>\r\n");
      out.write("<style>\r\n");
      out.write("textarea {\r\n");
      out.write("	resize : none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"main\" class=\"container mt-2 py-5 border rounded\">\r\n");
      out.write("	<!-- modal button -->\r\n");
      out.write("	<input type=\"hidden\" id=\"modalBtn\" class=\"btn btn-info btn-sm\" data-toggle=\"modal\" data-target=\"#myModal\" value=\"modal\" />\r\n");
      out.write("	\r\n");
      out.write("	<!-- modal -->\r\n");
      out.write("	<div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("		<div class=\"modal-dialog modal-dialog-centered modal-sm text-center\">\r\n");
      out.write("			<div class=\"modal-content\">\r\n");
      out.write("				<div class=\"modal-header bg-light\">\r\n");
      out.write("					<h4 class=\"modal-title\">회원가입</h4>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"modal-body bg-light\">\r\n");
      out.write("					회원 가입을 축하합니다.\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"modal-footer bg-light\">\r\n");
      out.write("					<button id=\"closeBtn\" class=\"btn btn-default btn-secondary\" type=\"button\" data-dismiss=\"modal\">닫기</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<h3 class=\"text-center text-danger\">회원가입</h3>\r\n");
      out.write("	<hr />\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"join\" method=\"post\" id=\"frm1\" name=\"frm1\">\r\n");
      out.write("		<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("		<div class=\"form-group\">\r\n");
      out.write("			<label for=\"user_id\">아이디</label>\r\n");
      out.write("			<input type=\"email\" class=\"form-control\" name=\"pid\" id=\"user_id\" placeholder=\"이메일 주소 입력\" required/>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"form-group\">\r\n");
      out.write("			<label for=\"user_pwd\">비밀번호</label>\r\n");
      out.write("			<input type=\"password\" class=\"form-control\" name=\"ppw\" id=\"user_pwd\" placeholder=\"비밀번호 입력\" required/>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"form-group\">\r\n");
      out.write("			<label for=\"user_address\">주소</label>\r\n");
      out.write("			<input type=\"text\" class=\"form-control\" name=\"paddress\" id=\"user_address\" placeholder=\"주소 입력\" required/>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"form-group\">\r\n");
      out.write("			<label for=\"user_hobby\">취미</label>\r\n");
      out.write("			<input type=\"text\" class=\"form-control\" name=\"phobby\" id=\"user_hobby\" placeholder=\"취미 입력\" required/>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"form-group\">\r\n");
      out.write("			<label for=\"user_profile\">취미</label>\r\n");
      out.write("			<textarea class=\"form-control\" name=\"pprofile\" id=\"user_profile\" placeholder=\"자기소개 입력\" rows=\"10\" required></textarea>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"d-flex justify-content-end\">\r\n");
      out.write("			<input type=\"submit\" value=\"완료\" class=\"btn btn-sm btn-primary\"/>&nbsp;&nbsp;\r\n");
      out.write("			<input type=\"reset\" value=\"취소\" class=\"btn btn-sm btn-danger\" />\r\n");
      out.write("		</div>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("	var frm = $('#frm1');\r\n");
      out.write("	\r\n");
      out.write("	frm.submit(function(e) {\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : frm.attr('action') ,\r\n");
      out.write("			type : frm.attr('method') ,\r\n");
      out.write("			data : frm.serialize() ,\r\n");
      out.write("									//search('str') : 문자열로된 객체에서 str이 있는지 찾고, boolean으로 반환\r\n");
      out.write("			success : function(data) {\r\n");
      out.write("				if ( data.search(\"join_success\") > -1 ) {\r\n");
      out.write("					$('.modal-body').text('회원가입을 축하합니다.');\r\n");
      out.write("					\r\n");
      out.write("					// trigger(event) : 자동으로 이벤트가 일어나도록 한다.\r\n");
      out.write("					$('#modalBtn').trigger('click');\r\n");
      out.write("					$('#closeBtn').click(function(e) {\r\n");
      out.write("						e.preventDefault();\r\n");
      out.write("						location.href = \"login_view\";\r\n");
      out.write("					});\r\n");
      out.write("				} else {\r\n");
      out.write("					$('.modal-body').text('동일한 아이디가 존재합니다.');\r\n");
      out.write("					$('#modalBtn').trigger('click');\r\n");
      out.write("				}\r\n");
      out.write("			},\r\n");
      out.write("			error : function(data) {\r\n");
      out.write("				$('.modal-body').text('동일한 아이디가 존재합니다.');\r\n");
      out.write("				$('#modalBtn').trigger('click');\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	})\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
