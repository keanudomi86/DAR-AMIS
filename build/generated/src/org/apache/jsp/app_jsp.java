package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class app_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/header.jsp", out, false);
      out.write(" \n");
      out.write("    <title>DAR-AMIS | APP</title>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("\n");
      out.write("  <section id=\"container\" >\n");
      out.write("      <!-- **********************************************************************************************************************************************************\n");
      out.write("      TOP BAR CONTENT & NOTIFICATIONS\n");
      out.write("      *********************************************************************************************************************************************************** -->\n");
      out.write("      <!--header start-->\n");
      out.write("      \n");
      out.write("      <header class=\"header black-bg\">\n");
      out.write("              <div class=\"sidebar-toggle-box\">\n");
      out.write("                  <div class=\"fa fa-bars tooltips\" data-placement=\"right\" data-original-title=\"Toggle Navigation\"></div>\n");
      out.write("              </div>\n");
      out.write("            <!--logo start-->\n");
      out.write("            <a href=\"index.jsp\" class=\"logo\"><b>DAR-AMIS</b></a>\n");
      out.write("            <!--logo end-->\n");
      out.write("            <div class=\"nav notify-row\" id=\"top_menu\">\n");
      out.write("                <!--  notification start -->\n");
      out.write("                <!-- -->\n");
      out.write("                <ul class=\"nav top-menu\">\n");
      out.write("                    <!-- settings start -->\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                        <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"index.html#\">\n");
      out.write("                            <i class=\"fa fa-tasks\"></i>\n");
      out.write("                            <span class=\"badge bg-theme\">4</span>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu extended tasks-bar\">\n");
      out.write("                            <div class=\"notify-arrow notify-arrow-green\"></div>\n");
      out.write("                            <li>\n");
      out.write("                                <p class=\"green\">You have 4 pending tasks</p>\n");
      out.write("                            </li>\n");
      out.write("                            </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li id=\"header_inbox_bar\" class=\"dropdown\">\n");
      out.write("                        <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"index.html#\">\n");
      out.write("                            <i class=\"fa fa-envelope-o\"></i>\n");
      out.write("                            <span class=\"badge bg-theme\">5</span>\n");
      out.write("                        </a>\n");
      out.write("                        <ul class=\"dropdown-menu extended inbox\">\n");
      out.write("                            <div class=\"notify-arrow notify-arrow-green\"></div>\n");
      out.write("                            <li>\n");
      out.write("                                <p class=\"green\">You have 5 new messages</p>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                </ul>            \n");
      out.write("                            \n");
      out.write("                <!--  notification end -->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"top-menu\">\n");
      out.write("            \t<ul class=\"nav pull-right top-menu\">\n");
      out.write("                    <li><a class=\"logout\" href=\"index.jsp\">Logout</a></li>\n");
      out.write("            \t</ul>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("      \n");
      out.write("      <!--header end-->\n");
      out.write("      \n");
      out.write("      <!-- **********************************************************************************************************************************************************\n");
      out.write("      MAIN SIDEBAR MENU\n");
      out.write("      *********************************************************************************************************************************************************** -->\n");
      out.write("      <!--sidebar start-->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/sidebarcheck.jsp", out, false);
      out.write("\n");
      out.write("      <!--sidebar end-->\n");
      out.write("      \n");
      out.write("      <!-- **********************************************************************************************************************************************************\n");
      out.write("      MAIN CONTENT\n");
      out.write("      *********************************************************************************************************************************************************** -->\n");
      out.write("      <!--main content start-->\n");
      out.write("         <section id=\"main-content\">\n");
      out.write("          <section class=\"wrapper\">\n");
      out.write("              <section class=\"content-header\">\n");
      out.write("                    <h1>\n");
      out.write("                        Annual Procurement Plan - Form\n");
      out.write("                        <small>Choices</small>\n");
      out.write("                        <h4 class=\"text-right text-bold\"><div name=\"curDate\">00:00:00</div></h4> \n");
      out.write("                        <h4 class=\"text-right text-bold\"><div name=\"curTime\">00:00:00</div></h4>             \n");
      out.write("                    </h1>\n");
      out.write("                  <tr><button type=\"button\" class=\"btn btn-default\">Create</button></tr><tr><button type=\"button\" class=\"btn btn-default\">Edit</button></tr><tr><button type=\"button\" class=\"btn btn-default\">View List</button></tr>\n");
      out.write("\t\t</section><! --/wrapper -->\n");
      out.write("      </section>\n");
      out.write("     </section>\n");
      out.write("             <!-- /MAIN CONTENT -->\n");
      out.write("\n");
      out.write("      <!--main content end-->\n");
      out.write("      <!--footer start-->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/copyright.jsp", out, false);
      out.write("\n");
      out.write("      <!--footer end-->\n");
      out.write("  </section>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/footer.jsp", out, false);
      out.write(" \n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
