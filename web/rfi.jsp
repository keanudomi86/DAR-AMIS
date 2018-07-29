<%-- 
    Document   : rfi
    Created on : 03 19, 18, 5:08:17 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.RfiDeliveries"%>
<%@page import="dao.RfiFk"%>
<%@page import="dao.RfiRepairPost"%>
<%@page import="dao.Rfi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Pr"%>
<%@page import="dao.Po"%>
<%Po po = (Po)request.getAttribute("po");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | RFI</title>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }
    </style>
    <script>
        $(document).ready(function(){
            $("#repairSection").hide();
            
            $("[name='type_of_inspection']").change(function(){
                if($("[name='type_of_inspection']").val() == "Repair"){
                    $("#deliveriesSection").hide();
                    $("#repairSection").show();
                }else if($("[name='type_of_inspection']").val() == "Deliveries"){
                    $("#deliveriesSection").show();
                    $("#repairSection").hide();
                }
            });
        });
    </script>
    <script>
        function submitRFI(){
            if(confirm("Submit this form?")){
                alert($("#createRfiForm").serialize());
                
                $.post("<%=root%>/CreateRFI", $("#createRfiForm").serialize(), function(data){
                    alert(data);

                    //redirect to approve forms page
                    window.location = "<%=root%>/CreateForms";
                });
            }
        }
    </script>
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
                    <h1>Request for Inspection</h1>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    
			<div class="container-fluid">
                            <a href="/DAR-AMIS/CreateForms" class="previous" align="left">&laquo; Previous</a>
                               
                            <div class="panel panel-default">
                              <!-- P1 -->
                              <form id="createRfiForm">
                              <div class = "panel-heading panel-heading-custom"><p class="text-center"><strong>Request For Inspection</strong></p></div> 

                                <div class="panel-body">
                                  <div class="row">              
                                      <div class="col-sm-2"><label align= "text-center">Type of Inspection</label></div>
                                      <!-- DO NOT USE BUTTON DROPDOWNS FOR INPUT I REPEAT 
                                      DO NOT USE BUTTON DROPDOWNS FOR INPUT -->
                                      <div class="col-sm-2">
                                          <select name="type_of_inspection" class="form-control">
                                                <option active disabled>Choose Type Of Inspection</option>  
                                                <option>Repair</option>
                                                <option>Deliveries</option>
                                              </select>
                                      </div>

                                      <div class="col-sm-2">
                                          <div class="btn-group">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" name="type_of_repair" data-toggle="dropdown" id="options"> 
                                              <span id="typeOfRepair">Choose Type</span> <span class="caret"></span>
                                            </button>
                                              <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" id="preRepair" href="#" >Pre-Repair</a></li>
                                                <li><a class="dropdown-item" id="postRepair" href="#">Post-Repair</a></li>
                                              </ul>
                                                    <Script>
                                                      $(function(){
                                                        $("#preRepair").click(function () {
                                                        $("#typeOfRepair").text($(this).text());
                                                        });
                                                        $("#postRepair").click(function () {
                                                        $("#typeOfRepair").text($(this).text());
                                                        });
                                                      });
                                                    </Script> 
                                          </div>
                                      </div>

                                      <div class="col-sm-2">
                                          <div class="btn-group">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" name="type_of_property" data-toggle="dropdown" id="options"> 
                                              <span id="typeOfDeliveries">Choose Type</span> <span class="caret"></span>
                                            </button>
                                              <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" id="infra" href="#" >Infrastructure</a></li>
                                                <li><a class="dropdown-item" id="goods" href="#">Goods</a></li>
                                                <li><a class="dropdown-item" id="equip" href="#">Equipment</a></li>
                                                <li><a class="dropdown-item" id="others" href="#">Others</a></li>
                                              </ul>
                                                    <Script>
                                                      $(function(){
                                                        $("#infra").click(function () {
                                                        $("#typeOfDeliveries").text($(this).text());
                                                        });
                                                        $("#goods").click(function () {
                                                        $("#typeOfDeliveries").text($(this).text());
                                                        });
                                                        $("#equip").click(function () {
                                                        $("#typeOfDeliveries").text($(this).text());
                                                        });
                                                        $("#others").click(function () {
                                                        $("#typeOfDeliveries").text($(this).text());
                                                        });
                                                      });
                                                    </Script> 
                                          </div>
                                      </div>

                                      <div>
                                          <input type="text" name="others_property" align= "text-center" placeholder="Others">
                                      </div>

                                  </div>



                                </div>

                                <div id="repairSection"> <!-- Beginning of Repairs -->                      
                                <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Description</STRONG></p></div>
                                <div class = "panel-heading sub-panel-heading-custom"><p class="text-left"><STRONG>Repair of Property/ies</STRONG></p></div>
                                  <!--Start of panel-description-Repair Panel-->
                                  <div class="panel-body" id="panel-description-Repair">
                                    <!--R1 of panel-description-Repair Panel-->
                                    <div class="row">
                                      <div class="col-sm-2"><label align= "text-center">Type of Property</label></div>
                                      <div class="col-sm-2">
                                        <div class="btn-group">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" name="type_of_property" data-toggle="dropdown" id="options"> 
                                              <span id="typeOfProperty">Choose Type</span> <span class="caret"></span>
                                            </button>
                                              <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" id="top_vechicles" href="#" >Vehicles</a></li>
                                                <li><a class="dropdown-item" id="top_equip" href="#">Equipment</a></li>
                                                <li><a class="dropdown-item" id="top_ffe" href="#">FFE</a></li>
                                              </ul>
                                                    <Script>
                                                      $(function(){
                                                        $("#top_vechicles").click(function () {
                                                        $("#typeOfProperty").text($(this).text());
                                                        });
                                                        $("#top_equip").click(function () {
                                                        $("#typeOfProperty").text($(this).text());
                                                        });
                                                        $("#top_ffe").click(function () {
                                                        $("#typeOfProperty").text($(this).text());
                                                        });
                                                      });
                                                    </Script> 
                                        </div>
                                      </div>
                                    </div>

                                     <!-- 2 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R3 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Model/Brand</label></div>
                                        <div class="col-sm-2"><input type="text" name="model" align= "text-center" placeholder="Model/Brand"></div>              
                                    </div>
                                     <!-- 4 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R5 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Engine No./Serial No.</label></div>
                                        <div class="col-sm-2"><input type="text" name="engine_no" align= "text-center" placeholder="Engine No./Serial No."></div>                  
                                    </div>
                                    <!-- 6 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R7 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Plate No./Property No.</label></div>
                                        <div class="col-sm-2"><input type="text" name="plate_no" align= "text-center" placeholder="Plate No./Property No."></div>                  
                                    </div>
                                    <!-- 8 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R9 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Defects/Complaints/Scope of Work</label></div>
                                        <div class="col-sm-4"><textarea rows="3" name="scope" cols="100" placeholder="Defects/Complaints/Scope of Work"></textarea></div>                  
                                    </div>
                                    <!-- 10 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R11 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">End-User/Office</label></div>
                                        <div class="col-sm-2"><input type="text" name="end_user" align= "text-center" placeholder="End-User/Office"></div>                  
                                    </div>
                                    <!-- 12 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R13 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Amount</label></div>
                                        <div class="col-sm-2"><input type="text" name="amount" align= "text-center" placeholder="Amount"></div>                  
                                    </div>
                                    <!-- 14 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R15 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><h4><STRONG>Attachments</STRONG></h4></div>
                                    </div>
                                    <!-- 16 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R17 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><h5><STRONG>Pre-Repair</STRONG></h5></div>
                                    </div>
                                    <!--R18 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-4">
                                          <div class="form-check">
                                              <input type="checkbox" name="rsps" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Request for Spare Parts & Services (RSPS - for Vechicles)</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R19 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-4">
                                          <div class="form-check">
                                              <input type="checkbox" name="rims" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Request for Infra Materials & Services (RIMS - for Infras)</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R20 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-6">
                                          <div class="form-check">
                                            <input type="checkbox" name="rrdps" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Request for Replacement of Def. Parts & Services (RRDPS - for FFE)</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!-- 21 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R22 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><h5><STRONG>Post-Repair</STRONG></h5></div>
                                    </div> 
                                    <!--R23 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-4">
                                          <div class="form-check">
                                            <input type="checkbox" name="pr_rsps" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Purchase Request/RSPS</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R24 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-4">
                                          <div class="form-check">
                                            <input type="checkbox" name="jo_po_contract" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Job Order/Purchase Order/Contract</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R25 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-6">
                                          <div class="form-check">
                                              <input type="checkbox" name="oc_dr_si_or" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Original Copy of DR/Sales Invoice/OR</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R26 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-6">
                                          <div class="form-check">
                                            <input type="checkbox" name="bids" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Abstract of Bids/Bids Documents/Canvass</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R27 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-6">
                                          <div class="form-check">
                                              <input type="checkbox" name="wmr" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Waste Material Report, in case of replacement of parts and accessories</label>
                                          </div>
                                        </div>                    
                                    </div>
                                  </div> <!--end of panel-description-Repair Panel-->
                                </div>  <!-- end of repair -->


                                <div id="deliveriesSection"> <!-- Beginning of Deliveries -->
                                <!--Start of panel-description-Deliveries Panel-->  
                                <div class = "panel-heading sub-panel-heading-custom"><p class="text-left"><STRONG>Deliveries</STRONG></p></div>
                                  <!--Start of panel-description-Description Panel-->
                                  <div class="panel-body" id="panel-description-Deliveries">
                                    <!--R1 of panel-description-Deliveries Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Supplier/Dealer</label></div>
                                        <div class="col-sm-2"><input type="text" name="supplier" align= "text-center" placeholder="Supplier/Dealer"></div>              
                                    </div>
                                     <!-- 2 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R3 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Invoice No.</label></div>
                                        <div class="col-sm-2"><input type="text" name="invoice_no" align= "text-center" placeholder="Invoice No."></div>                  
                                    </div>
                                    <!-- 4 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R5 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">DR No</label></div>
                                        <div class="col-sm-2"><input type="text" name="dr_no" align= "text-center" placeholder="DR No"></div>                  
                                    </div>
                                    <!-- 6 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R7 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">PR No</label></div>
                                        <div class="col-sm-2"><input type="text" name="pr_no" align= "text-center" value="<%=po.getIdPr().getIdPr()%>" /></div>                 
                                    </div>
                                    <!-- 8 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R9 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">PO No</label></div>
                                        <div class="col-sm-2"><input type="text" name="po_no" align= "text-center" value="<%=po.getIdPo()%>"></div>                  
                                    </div>
                                    <!-- 10 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R11 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">End-User/Office</label></div>
                                        <div class="col-sm-2"><input type="text" name="end_user_office" align= "text-center" placeholder="End-User/Office"></div>                  
                                    </div>
                                    <!-- 12 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R13 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><label align= "text-center">Amount</label></div>
                                        <div class="col-sm-2"><input type="text" name="amount_2" align= "text-center" placeholder="Amount"></div>                  
                                    </div>
                                    <!-- 14 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R15 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><h4><STRONG>Attachments</STRONG></h4></div>
                                    </div>
                                    <!-- 16 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R17 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-2"><h5><STRONG>Deliveries</STRONG></h5></div>
                                    </div>
                                    <!--R18 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-4">
                                          <div class="form-check">
                                              <input type="checkbox" name="pr_2" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Purchase Request</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R19 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-4">
                                          <div class="form-check">
                                            <input type="checkbox" name="po_contract_lease" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Purchase Order/Contract/Lease Agreement</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R20 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-6">
                                          <div class="form-check">
                                              <input type="checkbox" name="oc_dr_si_or_2" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Orginal Copy of DR/Sales Invoice/OR</label>
                                          </div>
                                        </div>                    
                                    </div>
                                    <!--R21 of panel-description-Repair Panel-->
                                    <div class="row">
                                        <div class="col-sm-6">
                                          <div class="form-check">
                                              <input type="checkbox" name="bids_2" class="form-check-input" id="exampleCheck1">
                                            <label  class="form-check-label" for="exampleCheck1">Abstract of Bids/Bids Documents/Canvass</label>
                                          </div>
                                        </div>                    
                                    </div>
                                  </div> <!--end of panel-description-Deliveries Panel-->

                                  <!--Start of Approval Panel-->
                                  <div class = "panel-heading panel-heading-custom">
                                    <div class= "row">
                                      <div class="col-sm-2"><label align= "text-left">Approval</label></div>
                                    </div>
                                  </div>

                                  <div class="panel-body">
                                    <!--R1 of Approval Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Name</label></div>
                                      <div class="col-sm-2"><input type="text" name="name_approve"  align= "text-center" placeholder="Name"></div>                          
                                    </div>
                                    <!-- 2 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R3 of Approval Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Designation</label></div>
                                      <div class="col-sm-2"><input type="text" name="designation_approve" align= "text-center" placeholder="Designation"></div>                          
                                    </div>
                                    <!-- 4 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R5 of Approval Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Date</label></div>
                                        <div class="col-sm-2">
                                      <!-- <form method="post"> 
                                       <div class="form-group "> -->

                                          <div class="input-group">
                                          <!-- This comment out adds an icon at the left side of the date text-->
                                          <!--<div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                          </div> -->
                                            <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text">
                                          </div>
                                        </div>                          
                                    </div>
                                            <!-- Date script for JS -->
                                            <script>
                                              $(document).ready(function(){
                                                  var date_input=$('input[name="date"]'); //our date input has the name "date"
                                                  var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                                                  date_input.datepicker({
                                                      format: 'mm/dd/yyyy',
                                                      container: container,
                                                      todayHighlight: true,
                                                      autoclose: true,
                                                  })
                                              })
                                            </script>

                                  </div>


                                  <!--Start of Management-Use Panel-->
                                  <div class = "panel-heading panel-heading-custom">
                                    <div class= "row">
                                      <div class="col-sm-2"><label align= "text-left"> </label></div>
                                    </div>
                                  </div>

                                  <div class="panel-body">
                                    <!--R1 of Management-Use Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Deliveries</label></div>
                                      <div class="col-sm-4"><textarea rows="3" name="deliveries" cols="100" placeholder="Deliveries"></textarea> </div>                          
                                    </div>
                                    <!-- 2 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R3 of Management-Use Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Control No</label></div>
                                      <div class="col-sm-2"><input type="text" name="control_no" align= "text-center" placeholder="Control No"></div>                          
                                    </div>
                                    <!-- 6 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R7 of Management-Use Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Pre-Repair</label></div>
                                      <div class="col-sm-4"><textarea rows="3" name="deliveries_pre_repair" cols="100" placeholder="Deliveries"></textarea> </div>                          
                                    </div>
                                    <!-- 8 Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
                                    <!--R9 of Management-Use Panel-->
                                    <div class="row">                
                                      <div class="col-sm-2"><label align= "text-center">Post-Repair</label></div>
                                      <div class="col-sm-4"><textarea rows="3" name="deliveries_post_repair" cols="100" placeholder="Deliveries"></textarea> </div>                          
                                    </div>              
                                  </div>
                                 </div> <!-- End of deliveries -->

                              </form>    
                              </div>
                     
                            <p align="center">                         
                                <button onclick="submitRFI()">Submit</button>
                            </p>
                        </div>

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


