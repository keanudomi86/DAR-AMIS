<%-- 
    Document   : approve_forms
    Created on : 02 13, 18, 6:04:28 PM
    Author     : BavarianHotdog

    TRANSFORM INTO VIEW ONLY

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | Error</title>
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
                    <h1>Server Error</h1>
                    <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                    <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>         
                </section>
              
              <h5>The server has encountered an error. Please try again later.</h5>
              <h5>Error details: </h5>
              <div><%=exception.getMessage()%></div>
          </section>
      <!--main content end-->
  </section>
      <jsp:include page="WEB-INF/copyright.jsp" /> 
      <jsp:include page="WEB-INF/footer.jsp" />
  </body>
</html>
