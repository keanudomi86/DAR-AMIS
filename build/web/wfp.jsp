<%-- 
    Document   : wfp
    Created on : 02 8, 18, 6:38:27 PM
    Author     : BavarianHotdog
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | WFP</title>
  </head>

  <body>

  <section id="container" >
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
                        Work and Financial Plan - Form 
                        <!--<small>Choices</small>-->
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                 <div class="container-fluid">
    <!-- Project Details -->

      <form role="form" onsubmit="toSubmit">
        <table style="width:100%">
          <tr>
            <td>
            <div class="row">
              <div class="col-s-1">
               <div class="form-group">
                <label for="ProgActProj">Program/Activity/Project</label>
                <input type="text" class="form-control" id="refnum" placeholder="Program/Activity/Project">
               </div>
              </div>
            </td>

            <td COLSPAN=2>
            <div class="row">
              <div class="col-s-4">
               <div class="form-group">
                <label for="weightAssign">Weight Assignment Per Activity</label>
                <input type="text" class="form-control" id="projectName" placeholder="Weight Assignment Per Activity">
               </div>
              </div>
            </div>
          </td>
        </tr>
        <form role="form">
            <table style="width:100%">  
        <tr>
            <td COLSPAN=2>
             
            <div class="row">
              <div class="col-s-4">
                <div class="form-group">
                <label for="clientName">Key Performance Indicators</label>
                <input type="text" class="form-control" id="clientName" placeholder="Key Performance Indicators">
               </div>
              </div>
            </td>
           
     
            <tr>
            <td COLSPAN=2>
            <div class="row">
              <div class="col-s-5">
                
                <label for="clientName">1st</label>
                <input type="text" class="form-control" id="clientName" placeholder="1st">
               </div>
              </div>
            </td>
            </tr>
            <tr>
            <td COLSPAN=2>
            <div class="row">
              <div class="col-s-5">
                
                <label for="clientName">2nd</label>
                <input type="text" class="form-control" id="clientName" placeholder="2nd">
               </div>
              </div>
            </td>
            </tr>
      </tr>
            <tr>
            <td COLSPAN=2>
            <div class="row">
              <div class="col-s-5">
                
                <label for="clientName">3rd</label>
                <input type="text" class="form-control" id="clientName" placeholder="3rd">
               </div>
              </div>
            </td>
            </tr>
            <tr>
            <td COLSPAN=2>
            <div class="row">
              <div class="col-s-5">
                
                <label for="clientName">4th</label>
                <input type="text" class="form-control" id="clientName" placeholder="4th">
               </div>
              </div>
            </td>
            </tr>
      </tr>
            </table>
        </form>
          <tr>
            <td COLSPAN=2>
          <div class="row">
               <div class="form-group">
                <label for="kpi">Key Performance Indicators</label>
                <input type="text" class="form-control" id="projectName" placeholder="Key Performance Indicators">
               </div>
              </div>
            <div class="row">
              <div class="col-s-4">
                <div class="form-group">
                <label for="clientName">Client</label>
                <input type="text" class="form-control" id="clientName" placeholder="Client's  Name">
               </div>
              </div>
            <div class="row">
              <div class="col-s-4">
                <div class="form-group">
                <label for="clientName">Position</label>
                <input type="text" class="form-control" id="clientName" placeholder="Client's Position">
               </div>
              </div>
            </td>
            </tr>
            <tr>
              <td COLSPAN=2>
              <div class="row">
                <label for="location">Client's Address</label>
                <input type="text" class="form-control" id="location" placeholder="Client's Address">
             </div>
           </td>
           </tr>
           <tr>
            <td>            <div class="row">
            <div class="col-s-4">
               <div class="form-group">
                <label for="contactNumber">Landline/Fax No.</label>
                <input type="text" class="form-control" id="contactNumber" placeholder="Landline/Fax No.">
               </div>
              </div>                
            </td>
            <td>
            <div class="row">
            <div class="col-s-4">
               <div class="form-group">
                <label for="contactNumber">Email/Mobile No.</label>
                <input type="text" class="form-control" id="contactNumber" placeholder="Email/Mobile No.">
               </div>
              </div> 
              </td>               
            </tr>
            <tr>
            <td COLSPAN=2>
            <div class="row">
               <div class="form-group">
                <label for="projectName">Scope of Works</label>
                <input type="text" class="form-control" id="projectName" placeholder="Scope of Works">
               </div>
              </div>
            </td>
          </tr>
          <tr>
            <td>
           <div class="row">
            <div class="col-s-5">  
              <div class="form-group">
                <label for="startingDate">Starting Date</label>
                <input type="date" placeholder="Starting Date" class="form-control" id="startingDate">
              </div>
            </div>
          </td>
            <td>
            <div class="col-s-5">
              <div class="form-group">
                <label for="completionDate">End Date</label>
                <input type="date" placeholder="End Date" class="form-control" id="completionDate">
              </div>
            </div>
          </div>
        </td>
        </tr>
            <br>
            <tr>
            <td COLSPAN=2>
            <center> 
              <!-- <a class="btn btn-primary" href="AddProject_ViewNewProject.html" role="button"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Done</a> --> 
              <input type="submit" value="Submit"> </center> 
            </td>
          </tr>
          </div>

        </div>
      </div>
    </form>
              </section><! --/wrapper -->
      </section>
     </section>
             <!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" />
      <!--footer end-->
  </section>
      <jsp:include page="WEB-INF/footer.jsp" /> 
  </body>
</html>
