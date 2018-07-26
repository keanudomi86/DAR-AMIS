<%-- 
    Document   : create_reports
    Created on : 03 19, 18, 12:37:57 PM
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
    <script>
        function submitAPP(){
            alert($("[name='appForm']").serialize());
            
            if(confirm("Submit form?"))
            {
                $.post("<%=root%>/CreateAPP", $("[name='appForm']").serialize(), function(data){
                    alert(data);
                });
            }
        }
    </script>

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
                  <h1>Create Reports </h1>
                        <small>- Please select the report to generate: </small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>
                        
                 <div class="container">
                    <div class="panel panel-default">

                      <!-- P1 -->
                      <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Reports Generation</STRONG></p></div> 
                                          
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
                      
                                          <br>
                            <div class="panel-body">
                                
                                <div class="row">
                                    <label class="col-md-3">Select Report to Generate</label>
                                        <select class="col-md-3" name="reportGenerate" placeholder="" required>
                                            <!--<option disabled selected>Input Report Type</option> -->
                                            <option value="1">Report on Physical Count of Inventories</option>
                                            <option value="2">Report on the Physical Count of Plant Property Equipment</option>
                                            <option value="3">Report of Supplies and Materials Issued</option>
                                            <option value="4">Inspection and Acceptance Report</option>
                                            <option value="5">Inventory and Inspection Report of Unserviceable Property</option>
                                            <option value="6">Waste Materials Report</option>
                                            <option value="7">Property Transfer Report</option>
                                            <option value="8">Stock Card</option>
                                            <option value="9">Property Card</option>
                                        </select>
                                </div>
                                
                                <div class="row">
                                   <label class="col-md-3">Choose what Forms to import</label>
                                    <select class="col-md-3" name="formImport" placeholder="" required>
                                        <option disabled selected>Input Form Type</option>
                                        <option>Purchase Request</option>
                                        <option>Purchase Order</option>
                                        <option>Property Acknowledgment Receipt</option>
                                        <option>Request for Inspection</option>
                                        <option>Assignment of Inspector Form</option>
                                        <option>Inventory Custodian Slip</option>
                                        <option>Requisition and Issuance Slip</option>
                                    </select>
                                      <!--<label class="container">One
                                        <input type="checkbox" checked="checked">
                                        <span class="checkmark"></span>
                                      </label>

                                      <label class="container">Two
                                        <input type="checkbox">
                                        <span class="checkmark"></span>
                                      </label>

                                      <label class="container">Three
                                        <input type="checkbox">
                                        <span class="checkmark"></span>
                                      </label>

                                      <label class="container">Four
                                        <input type="checkbox">
                                        <span class="checkmark"></span>
                                      </label> -->
                                </div>
                                
                                 <div class="row">  
                                    <label class="col-md-3">Choose Form ID:</label>
                                        <select class="col-md-3" name="formImport" placeholder="" required>
                                            <option disabled selected>Select Form IDs:</option>
                                            <option>00001</option>
                                            <option>00002</option>
                                        </select>
                                </div>
                            </div>
                        
                        <div class="panel-footer">
                              <p class="text-center"><button class="btn btn-default" onclick="generateReport()">Generate</button></p>
                        </div>
                                          
                    </div>
                     
                    
                    </div>
                    </section>
                          </section>
                                                  <div class= "row">
                                                    <div class="col-sm-2"><label align= "text-left"> </label></div>

                                                  </div>
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