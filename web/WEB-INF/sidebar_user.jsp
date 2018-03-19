<%-- 
    Document   : sidebar_user
    Created on : 02 14, 18, 5:07:04 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Employee"%>
<%@page import="dao.Tier"%>
<%Employee emp = (Employee)session.getAttribute("userData");%>
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
                <!--<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="lock.jsp">Lock</a></li>-->
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
                          <i class="fa fa-bookmark"></i>
                          <span>User Functions</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="activate_accounts.jsp">Activate Accounts</a></li>
                          <li><a  href="change_usertier.jsp">Manage Users</a></li>
                          <li><a  href="deactivate_accounts.jsp">Deactivate Accounts</a></li>
                          <li><a  href="make_announcement.jsp">Make Announcement</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>For Approval</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="aforms.jsp">Forms</a></li>
                          <li><a  href="areports.jsp">Reports</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Asset</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="monitoring.jsp">Monitoring and Tracking</a></li>
                          <!--<li><a  href="buttons.html">Tracking</a></li> -->
                          <li><a  href="resource_alloc.jsp">Resource Allocation</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-expand"></i>
                          <span>View</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="forms.jsp">Forms</a></li>
                          <li><a  href="responsive_table.jsp">Reports</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-question-circle"></i>
                          <span>Help</span>
                      </a>
                      <ul class="sub">
                          <li><a href="faqs.jsp">FAQs</a></li>
                          <li><a href="guide.jsp">DAR-AMIS Help Guide</a></li>
                      </ul>
                  </li>
                  <!--<li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Reports</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="forms.jsp">View Filled Forms</a></li>
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.jsp">Responsive Table</a></li>
                      </ul>
                  </li>-->
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>