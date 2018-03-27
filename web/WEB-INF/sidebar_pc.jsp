<%-- 
    Document   : sidebar_pc Property Officer
    Created on : 02 13, 18, 2:39:22 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Employee"%>
<%@page import="dao.Tier"%>
<%Employee emp = (Employee)session.getAttribute("userData");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <!--<ul class="nav top-menu">
                    <!-- settings start
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
                </ul> -->            
                            
                <!--  notification end -->
            </div>
            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="profile.jsp">Profile</a></li>
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="index.jsp">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->      
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.jsp"><img src="img/skype2512x512.png" class="img-circle" width="60"></a></p>
                  <h5 class="centered"><%= emp.getFirstName()%> <%= emp.getLastName()%></h5>
                  <p class="centered"><i class="fa fa-circle text-success"></i> Online</p>
                  
                  
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-pencil"></i>
                          <span>Create</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="create_forms.jsp">Forms</a></li>
                          <li><a  href="create_reports.jsp">Reports</a></li>
                      </ul>
                  </li>
                 <!-- <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-pagelines"></i>
                          <span>Verify Status</span>
                      </a>
                      <ul class="sub">
                          <li><a href="verify_forms.jsp">Forms</a></li>
                      </ul>
                  </li> -->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>For Approval</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="approve_forms.jsp">Forms</a></li>
                          <li><a  href="approve_reports.jsp">Reports</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Asset</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="monitoring.jsp">Monitoring and Tracking</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-question-circle"></i>
                          <span>Help</span>
                      </a>
                      <ul class="sub">
                          <li><a href="faqs.jsp">FAQs</a></li>
                          <li><a href="help.jsp">DAR-AMIS Help Guide</a></li>
                      </ul>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>