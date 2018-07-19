<%@page import="dao.Employee"%>
<%@page import="dao.Tier"%>
<%Employee emp = (Employee)session.getAttribute("userData");%>
<%String root = request.getContextPath();%>
<!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="dir_dashboard.jsp" class="logo"><b>DAR-AMIS</b></a>
            <!--logo end-->
            
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
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
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
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
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-divya.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                     Hi, I need your help with this.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-danro.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Love your new Dashboard.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
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
                          <li><a  href="<%=root%>/ActivateAccounts">Activate Accounts</a></li>
                          <li><a  href="<%=root%>/ManageAccounts">Manage Users</a></li>
                          <li><a  href="<%=root%>/DeactivateAccounts">Deactivate Accounts</a></li>
                          <li><a  href="make_announcement.jsp">Make Announcement</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-download"></i>
                          <span>Procurement</span>
                      </a>
                      <ul class="sub">
                          <li><a href="wfp.jsp">WFP</a></li>
                          <li><a href="ppmp.jsp">PPMP</a></li>
                          <li><a href="<%=root%>/APPForm">APP</a></li>
                      </ul>
                  </li>
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
                          <!--<li><a  href="buttons.html">Tracking</a></li> -->
                          <li><a  href="resource_alloc.jsp">Resource Allocation</a></li>
                          <li><a  href="assetacquisition.jsp">Asset Acquisition</a></li>
                          <li><a  href="assetassignment.jsp">Asset Assignment</a></li>
                          <li><a  href="assethistory.jsp">Asset History</a></li>
                          <li><a  href="assetlocation.jsp">Asset Location</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-expand"></i>
                          <span>View</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="ProcurementView.jsp">View Procurement Forms</a></li>
                          <li><a  href="pr.jsp">PR</a></li>
                          <li><a  href="formrepo.jsp">Forms</a></li>
                          <li><a  href="responsive_table.jsp">Reports</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-pencil"></i>
                          <span>Create</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="/DAR-AMIS/CreateForms">Forms</a></li>
                          <li><a  href="create_reports.jsp">Reports</a></li>
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
