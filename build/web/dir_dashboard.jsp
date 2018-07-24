<%-- 
    Document   : dir_dashboard
    Created on : 03 7, 18, 3:59:25 AM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Announcements"%>
<%@page import="dao.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.Instant"%>
<%@page import="java.time.ZoneOffset"%>
<%Employee e = (Employee)(session.getAttribute("userData"));%>
<%ArrayList<Announcements> announcements = (ArrayList<Announcements>)(session.getAttribute("announcements"));%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | Director Dashboard</title>
  </head>

  <body>
     <section id="container">
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
     
      
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
                  <!--<div class="pagination">
                      <div class="left">
                          <a href="#" class="previous" align="left">&laquo; Previous</a>
                      </div>
                      <div class="right">
                          <a href="#" class="next" align="right">Next &raquo;</a>
                      </div>
                  </div> 
                  <a href="#" class="previous" align="left">&laquo; Previous</a>
                  <!--<a href="#" class="text-right text-bold" align="right">Next &raquo;</a> -->
                    <h1>
                        Welcome!
                        <small>Director</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <!--main content start-->
          <section class="wrapper">
          	
				<div class="row">

              <div class="row mt">
                  <div class="col-md-12">
                      <div class="content-panel">
                           <table class="table table-striped table-advance table-hover">
                              <h3><p class="centered"><i class="fa fa-bullhorn"></i>  Announcements</p></h3>
	                  	  	  <hr>
                                  <thead>
                                      <tr>
                                        <td>Subject</td>
                                        <td class="hidden-phone">Announcement</td>
                                        <td>Date Posted</td>
                                        <td>Posted By</td>
                                        
                                      </tr>
                                  </thead>
                                  <tbody>
                                  <%if(announcements != null && !announcements.isEmpty()){%>
                                    <%for(Announcements a: announcements){%>
                                      <tr>
                                          <td><a href="#"><%=a.getSubject()%></a></td>
                                          <td class="hidden-phone"><%=a.getAnnouncement()%></td>
                                          <%LocalDateTime ldt = LocalDateTime.ofInstant(a.getDatePosted().toInstant(), ZoneOffset.systemDefault());%>
                                          <td><%=ldt.getMonth()%> <%=ldt.getDayOfMonth()%>, <%=ldt.getYear()%></td>
                                          <td><%=a.getAnnouncementBy().getFirstName()%> <%=a.getAnnouncementBy().getLastName()%></td>

                                        </tr>

                                    <%}%>
                                  <%}else{%>
                                    <tr>
                                          <td>N/A</td>
                                          <td>N/A</td>
                                          <td>N/A</td>
                                          <td>N/A</td>
                                    </tr>
                                  <%}%>  
                              </tbody>
                          </table>
                      </div>
                      </div><!-- /content-panel -->
                  </div><!-- /col-md-12 -->
              </div><!-- /row -->

		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
                                        
                      
                    
                    				
                </section>
          </section>
      <!--main content end-->
      
  </section>
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" /> 
      <!--footer end-->
      <jsp:include page="WEB-INF/footer.jsp" />
  </body>
</html>
