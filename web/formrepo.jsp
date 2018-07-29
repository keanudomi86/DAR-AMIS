<%-- 
    Document   : formrepo
    Created on : 03 23, 18, 9:03:11 PM
    Author     : BavarianHotdog
--%>

<%@page import="dao.FormRepo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<FormRepo> forms = (ArrayList<FormRepo>) request.getAttribute("forms");%>
<%String root = request.getContextPath();%>
<%boolean hasPrColumn = false;%>
<%boolean hasPoColumn = false;%>
<%boolean hasRfiColumn = false;%>
<!-- set which columns to display in the for loop below -->
<%for(FormRepo f: forms){
    if(f.getIdPr() != null){
        hasPrColumn = true;
    }
    if(f.getIdPo() != null){
        hasPoColumn = true;
    }
    if(f.getIdRfi() != null){
        hasRfiColumn = true;
    }
    
}%>
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
                                <th>Entry ID</th>
                                 <%if(hasPrColumn){%>
                                    <th>PR No.</th>
                                <%}%>
                                <%if(hasPoColumn){%>
                                    <th>Po No.</th>
                                <%}%>
                                <%if(hasRfiColumn){%>
                                    <th>RFI No.</th>
                                <%}%>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(FormRepo form: forms){%>
                            <tr>
                                <td><%=form.getIdFormRepo()%></td>
                                <%if(form.getIdPr() != null){%>
                                    <%if(request.getAttribute("mode") == "view"){%>
                                        <td><a href = "<%=root%>/PRPage?id=<%=form.getIdPr().getIdPr()%>"><%=form.getIdPr().getIdPr()%></a></td>
                                    <%} else if(request.getAttribute("mode").equals("create_po")){%>
                                        <td><a href = "<%=request.getAttribute("link")%><%=form.getIdPr().getIdPr()%>"><%=form.getIdPr().getIdPr()%></a></td>
                                    <%}else{%>
                                        <td><%=form.getIdPr().getIdPr()%></td>
                                    <%}%>
                                <%}else{%>
                                        <td>N/A</td>
                                <%}%>
                                
                                <%if(form.getIdPo() != null){%>
                                    <%if(request.getAttribute("mode") == "view"){%>
                                        <td><a href = "<%=root%>/POPage?id=<%=form.getIdPo().getIdPo()%>"><%=form.getIdPo().getIdPo()%></a></td>
                                    <%} else if(request.getAttribute("mode").equals("create_rfi")){%>
                                        <td><a href = "<%=request.getAttribute("link")%><%=form.getIdPo().getIdPo()%>"><%=form.getIdPo().getIdPo()%></a></td>
                                    <%}%>
                                <%}else{%>
                                        <td>N/A</td>
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

