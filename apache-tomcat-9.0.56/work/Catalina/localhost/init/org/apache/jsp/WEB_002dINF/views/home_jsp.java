/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-03-25 02:59:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(8);
    _jspx_dependants.put("jar:file:/D:/project_init/apache-tomcat-9.0.56/wtpwebapps/project_init/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-4.2.13.RELEASE.jar", Long.valueOf(1646873798857L));
    _jspx_dependants.put("jar:file:/D:/project_init/apache-tomcat-9.0.56/wtpwebapps/project_init/WEB-INF/lib/jstl-1.2.jar!/META-INF/x.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/project_init/apache-tomcat-9.0.56/wtpwebapps/project_init/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/project_init/apache-tomcat-9.0.56/wtpwebapps/project_init/WEB-INF/lib/spring-security-taglibs-4.2.13.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1560936316000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1644909417825L));
    _jspx_dependants.put("jar:file:/D:/project_init/apache-tomcat-9.0.56/wtpwebapps/project_init/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/project_init/apache-tomcat-9.0.56/wtpwebapps/project_init/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"_csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<meta name=\"_csrf_header\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.headerName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/b4e02812b5.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main/main.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footer.css\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("	function allComments() {\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: 'home/allComments.do',\r\n");
      out.write("			type: 'post',\r\n");
      out.write("		    beforeSend: function(xhr){\r\n");
      out.write("	 		   	var token = $(\"meta[name='_csrf']\").attr('content');\r\n");
      out.write("	 			var header = $(\"meta[name='_csrf_header']\").attr('content');\r\n");
      out.write("			        xhr.setRequestHeader(header, token);\r\n");
      out.write("			},\r\n");
      out.write("			success: function(data) {\r\n");
      out.write("				for ( var i = 0; i < data.length; i++ ) {\r\n");
      out.write("					let box = '<input type=\"text\" class=\"form-control comment\" value=\"' + data[i].comments + '\" readonly />'\r\n");
      out.write("							+ '<form action=\"home/recomment.do\" method=\"post\" name=\"refrm\" class=\"refrm\">'\r\n");
      out.write("							+ '<input type=\"text\" class=\"form-control col-10\" name=\"commentNum\" value=\"' + data[i].commentNum + '\"/>'\r\n");
      out.write("							+ '<input type=\"text\" class=\"form-control col-10\" name=\"mNum\" value=\"' + data[i].mNum + '\"/>'\r\n");
      out.write("							+ '<input type=\"text\" class=\"form-control col-10\" name=\"gNum\" value=\"' + data[i].gNum + '\"/>'\r\n");
      out.write("							+ '<input type=\"text\" class=\"form-control col-10\" name=\"inum\" value=\"' + data[i].iNum + '\"/>'\r\n");
      out.write("							+ '<div class=\"form-group row mx-0\">'\r\n");
      out.write("							+ '<input type=\"text\" class=\"form-control col-10\" id=\"recomment-input\" name=\"comments\"/>'\r\n");
      out.write("							+ '<button type=\"submit\" class=\"btn btn-sm btn-primary\" >댓글</button>'\r\n");
      out.write("							+ '</div>'\r\n");
      out.write("							+ '</form>';\r\n");
      out.write("					$('#commentary').append(box);\r\n");
      out.write("					\r\n");
      out.write("				}\r\n");
      out.write("			},\r\n");
      out.write("			error: function(data) {\r\n");
      out.write("				console.log(data);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	};\r\n");
      out.write("	\r\n");
      out.write("	allComments();\r\n");
      out.write("	\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container bg-secondary\">\r\n");
      out.write("<h3 class=\"display-4 font-italic\">Post</h3>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"commentary\">\r\n");
      out.write("	<form action=\"home/comment.do\" method=\"post\" name=\"frm\">\r\n");
      out.write("		<div class=\"form-group row mx-0\">\r\n");
      out.write("			<label for=\"comment-input\" class=\"col-1 mt-2\">댓글 : </label>\r\n");
      out.write("			<input type=\"text\" class=\"form-control col-10\" id=\"comment-input\" name=\"comments\"/>\r\n");
      out.write("\r\n");
      out.write("			<button type=\"button\" id=\"m-comment\" class=\"btn btn-sm btn-primary col-1\">댓글</button>\r\n");
      out.write("		</div>\r\n");
      out.write("	</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("	\r\n");
      out.write("	$('#m-comment').click(function(e) {\r\n");
      out.write("			e.preventDefault();\r\n");
      out.write("			\r\n");
      out.write("			let comment = $('#comment-input').val();\r\n");
      out.write("			\r\n");
      out.write("			if ( comment == null ) {\r\n");
      out.write("				alert('null exception');\r\n");
      out.write("				return false;\r\n");
      out.write("			};\r\n");
      out.write("			\r\n");
      out.write("			let data = {\r\n");
      out.write("					commentNum : 0,\r\n");
      out.write("					comments : comment,\r\n");
      out.write("					mNum : 0,\r\n");
      out.write("					gNum : 0,\r\n");
      out.write("					iNum : 0\r\n");
      out.write("			};\r\n");
      out.write("		\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: $('form').attr('action'),\r\n");
      out.write("				type: $('form').attr('method'),\r\n");
      out.write("				data: JSON.stringify(data),\r\n");
      out.write("				contentType: 'application/json; charset-utf-8',\r\n");
      out.write("	 		    beforeSend: function(xhr){\r\n");
      out.write("		 		   	var token = $(\"meta[name='_csrf']\").attr('content');\r\n");
      out.write("		 			var header = $(\"meta[name='_csrf_header']\").attr('content');\r\n");
      out.write("	 		        xhr.setRequestHeader(header, token);\r\n");
      out.write("	 		    },\r\n");
      out.write("				success: function(data) {\r\n");
      out.write("					if( data == 'success' ) {\r\n");
      out.write("						allComments();\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error: function(data) {\r\n");
      out.write("					console.log(data);\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	$('.refrm').submit(function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: $(this).attr('action'),\r\n");
      out.write("			type: $(this).attr('method'),\r\n");
      out.write("			success: function(data) {\r\n");
      out.write("				if( data == 'success' ) {\r\n");
      out.write("					allComments();\r\n");
      out.write("				}\r\n");
      out.write("			},\r\n");
      out.write("			error: function(data) {\r\n");
      out.write("				console.log(data);\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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