<%-- 
    Document   : pr_rundown
    Created on : 03 24, 18, 10:17:52 AM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Pr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Office"%>
<%ArrayList<Office> offices = (ArrayList<Office>)request.getAttribute("offices");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | PR Rundown</title>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
  </head>

  <body>

  <section id="container" >
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
                        View Accomplished Purchase Requests
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
			
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
                            <%for(Pr p: Pr){%>
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


