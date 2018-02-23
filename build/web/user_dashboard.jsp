<%-- 
    Document   : user_dashboard
    Created on : 02 7, 18, 6:05:19 PM
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
        <jsp:include page="WEB-INF/sidebar_user.jsp" />
      <!--sidebar end-->
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                    <h1>
                        Welcome!
                        <small>Director</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                                        
                      <div class="row mt">
                      <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb">
                      		<div class="white-panel pn">
                      			<div class="white-header">
						  			<h5>SAMPLE ASSET</h5>
                      			</div>
								<div class="row">
									<div class="col-sm-6 col-xs-6 goleft">
										<p><i class="fa fa-exclamation-circle"></i> 122</p>
									</div>
									<div class="col-sm-6 col-xs-6"></div>
	                      		</div>
	                      		<div class="centered">
										<img src="img/pc.jpg" width="120">
	                      		</div>
                      		</div>
                      	</div><!-- /col-md-4 -->
                      	
						<div class="col-md-4 mb">
							<!-- WHITE PANEL - TOP USER -->
							<div class="white-panel pn">
								<div class="white-header">
									<h5>NEWLY APPOINTED</h5>
								</div>
								<p><img src="img/ui-zac.jpg" class="img-circle" width="80"></p>
								<p><b>James Murray</b></p>
								<div class="row">
									<div class="col-md-6">
										<p class="small mt">MEMBER SINCE</p>
										<p>2018</p>
									</div>
								</div>
							</div>
						</div><!-- /col-md-4 -->
                      	<div class="col-md-4 mb">
							<!-- WHITE PANEL - TOP USER -->
							<div class="white-panel pn">
								<div class="white-header">
									<h5>NEWLY APPOINTED</h5>
								</div>
								<p><img src="img/lorde.jpg" class="img-circle" width="240"></p>
								<p><b>Maria Magalona</b></p>
								<div class="row">
									<div class="col-md-6">
										<p class="small mt">MEMBER SINCE</p>
										<p>2018</p>
									</div>
								</div>
							</div>
						</div><!-- /col-md-4 -->

                    </div><!-- /row -->
                    
                    				
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
