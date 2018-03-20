<%-- 
    Document   : make_announcement.jsp
    Created on : 03 7, 18, 3:59:25 AM
    Author     : BavarianHotdog
--%>

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
                    <h1>
                        Welcome!
                        <small>Director</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <!--main content start-->
                <section class="content">

                    <div class="box box-primary">

                        <div class="box-header">
                            <h3 class="box-title"><i class="glyphicon glyphicon-file"></i>Make Announcement</i></h3>
                        </div>

                        <div class="box-body border-radius-none">
                            <form action="SubmitAnnouncement" method="post">
                                <div class="col-md-12">
                                    <div class="form-group has-feedback">
                                        <input type="text" class="form-control" name="subject" placeholder="Subject" name="sub">
                                    </div>
                                    <div class="form-group has-feedback">
                                        <textarea class="form-control" name="announcement" placeholder="Announcement" rows="5"></textarea>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group has-feedback">
                                        <button type="submit" class="btn btn-default pull-right">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="control-sidebar-bg"></div>
            <! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
                                        
                      
                    
                    				
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
