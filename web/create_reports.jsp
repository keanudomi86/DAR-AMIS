<%-- 
    Document   : create_reports
    Created on : 03 19, 18, 12:37:57 PM
    Author     : BavarianHotdog
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | User Dashboard</title>
  </head>

  <body>
     <section id="container">
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <!--header end-->
      
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
        <jsp:include page="WEB-INF/sidebarcheck.jsp" />
      <!--sidebar end-->
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                    <h1>
                        Department of Agrarian Reform 
                        <small>- Create Reports</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                   <div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			Reports
                        <span class="caret"></span>
                        </button>
                            <ul class="dropdown-menu">
                          <li><a  href="iar.jsp">IAR</a></li>
                          <li><a  href="rpci.jsp">RPCI</a></li>
                          <li><a  href="rpcppe.jsp">RPCPPE</a></li>
                          <li><a  href="iirup.jsp">IIRUP</a></li>
                          <li><a  href="sc.jsp">SC</a></li>
                          <li><a href="pc.jsp">PC</a></li>
                          <li><a  href="wmr.jsp">WMR</a></li>
                          <li><a  href="ptr.jsp">PTR</a></li>
                          <li><a  href="rsmi.jsp">RSMI</a></li>
						    </ul>
						  </div>
                </section>
          </section>
      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" /> 
      <!--footer end-->
  </section>
      <jsp:include page="WEB-INF/footer.jsp" />
  </body>
</html>