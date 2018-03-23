<%-- 
    Document   : create_forms
    Created on : 03 19, 18, 12:37:43 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Pr"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Pr> prs = (ArrayList<Pr>)request.getAttribute("prs");%>
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
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>DAR-AMIS</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <!-- -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            </ul>
                    </li>
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                        </ul>
                </ul>            
                            
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="index.jsp">Logout</a></li>
            	</ul>
            </div>
        </header>
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
                        <small>- Create Forms</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                   <div class="btn-group">
						    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						      Create New Form
						      <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu">
                          <li><a href="/DAR-AMIS/PRPage">PR</a></li>
                          <li><a href="/DAR-AMIS/POPage">PO</a></li>
                          <li><a href="/DAR-AMIS/PARPage">PAR</a></li>
                          <li><a href="rfi.jsp">RFI</a></li>
                          <li><a href="aif.jsp">AIF</a></li>
                          <li><a href="ics.jsp">ICS</a></li>
                          <li><a href="/DAR-AMIS/RISPage">RIS</a></li>
                          <li><a href="sc.jsp">SC</a></li>
						    </ul>
						    </ul>
						  </div>
                </section>
              
                <section class="content-panel">
                    <table class="table table-striped table-responsive">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Entity Name</td>
                                <td>Office</td>
                                <td>Date</td>
                                <td>Approval Status</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(Pr p: prs){%>
                                <tr>
                                    <td><%=p.getIdPr()%></td>
                                    <td><%=p.getEntityName()%></td>
                                    <td><%=p.getIdOffice().getDepartment()%></td>
                                    <td><%=p.getDate()%></td>
                                    <td>You have no approval flag to determine approval status
                                    in your database. create one and modify entities accordingly
                                    to check approval status</td>
                                    
                                </tr>
                            <%}%>
                        </tbody>
                    </table>
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
