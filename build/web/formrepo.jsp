<%-- 
    Document   : formrepo
    Created on : 03 23, 18, 9:03:11 PM
    Author     : BavarianHotdog
--%>

<%@page import="dao.FormRepo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<FormRepo> prs = (ArrayList<FormRepo>) request.getAttribute("prs");%>
<%String link = (String)request.getAttribute("link");%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | Form Repository</title>
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
                        Forms Repository
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
			<section class="content-panel">
                    <table class="table table-striped table-responsive">
                        <thead>
                            <tr>
                                <th>Form ID</th>
                                <th>Form Type</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(FormRepo pr: prs){%>
                            <tr>
                                <%if(pr.getIdPr() != null){%>
                                    <td><a href = "<%=link + pr.getIdPr().getIdPr()%>"><%=pr.getIdPr().getIdPr()%></a></td>
                                    <td>PR</td>
                                <%}else if(pr.getIdPo() != null){%>
                                    <td><a href = "<%=link + pr.getIdPo().getIdPo()%>"><%=pr.getIdPo().getIdPo()%></a></td>
                                    <td>PO</td>
                                <%}%>
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

