<%-- 
    Document   : view_report_temp
    Created on : 03 19, 18, 2:38:04 PM
    Author     : BavarianHotdog
--%>

<%List<String> offices = (List<String>)request.getAttribute("offices");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | Create Reports</title>
  </head>
      <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
    <!--<script>
        function submitAPP(){
            alert($("[name='appForm']").serialize());
            
            if(confirm("Submit form?"))
            {
                $.post("<%=root%>/CreateAPP", $("[name='appForm']").serialize(), function(data){
                    alert(data);
                });
            }
        }
    </script> -->

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
                  <h1>View Report Templates </h1>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>
                        
                 <div class="container">
                    <div class="panel panel-default">

                      <!-- P1 -->
                      <div class = "panel-heading panel-heading-custom"><p class="text-center"><strong>Reports Template Selection</strong></p></div> 
                                          
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    Reports
                                    <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                      <li><a  href="iar.jsp">Inspection and Acceptance Report</a></li>
                                      <li><a  href="rpci.jsp">Report on Physical Count of Inventories</a></li>
                                      <li><a  href="rpcppe.jsp">Report on the Physical Count of Plant Property Equipment</a></li>
                                      <li><a  href="iirup.jsp">Inventory and Inspection Report of Unserviceable Property</a></li>
                                      <li><a  href="sc.jsp">Stock Card</a></li>
                                      <li><a href="pc.jsp">Property Card</a></li>
                                      <li><a  href="wmr.jsp">Waste Materials Report</a></li>
                                      <li><a  href="ptr.jsp">Property Transfer Report</a></li>
                                      <li><a  href="rsmi.jsp">Report of Supplies and Materials Issued</a></li>
                                    </ul>
                                </div>
                        </div>
                      
                                          <br>
                    </div>
                     
                </section>
            </section>
                    <!--</form>-->
        </section>
                              <!-- P3 -->
          </section>
      <!--main content end-->
      <!--footer start-->
      
      <!--footer end-->
        <jsp:include page="WEB-INF/copyright.jsp" />
        <jsp:include page="WEB-INF/footer.jsp" />
  </body>
</html>