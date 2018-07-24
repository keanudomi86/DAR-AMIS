<%-- 
    Document   : aif
    Created on : 03 19, 18, 5:08:31 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Aif"%>
<%@page import="dao.AifDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Pr"%>
<%@page import="dao.Po"%>
<%Pr pr = (Pr)request.getAttribute("pr");%>
<%Aif aif = (Aif) request.getAttribute("aif");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | AIF</title>
  </head>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
     <script>
        function createAIF(){
            if(confirm("Submit this form?")){
                url = "<%=root%>/CreateAIF";
                $.post(url, $("#aifForm").serialize(), function(data){
                    alert(data);
                });
            }
        }
    </script>
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
      <form action="CreateAIF" method="POST">
         <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                    <h1>
                        Assignment of Inspector Form
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <div class="container-fluid">
                       <a href="/DAR-AMIS/CreateForms" class="previous" align="left">&laquo; Previous</a>
                                <script>
                                    function submitAIF(){
                                        if(confirm("Submit this form?")){

                                            $.post("<%=root%>/CreateAIF", $("#createAifForm").serialize(), function(data){
                                                alert(data);

                                                //redirect to approve forms page
                                                window.location = "<%=root%>/CreateForms";
                                            });
                                        }
                                    }
                                </script>
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Assignment of Inspector Form</STRONG></p></div> 
          <div class="panel-body"> 
            <!-- First Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Date Request</label></div>
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
                 <!--<div class="form-group">
                  <div>
                   <button class="btn btn-primary " name="submit" type="submit">Submit</button>  
                  </div>
                 </div>
                 </form> 
                </div> -->

              <div class="col-sm-2"><label align= "text-center"></label></div>
              
              <div class="col-sm-2"><label align= "text-center">Control No.</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Control No."></div> 

          </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date Received</label></div>
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
                 <!--<div class="form-group">
                  <div>
                   <button class="btn btn-primary " name="submit" type="submit">Submit</button>  
                  </div>
                 </div>
                 </form> 
              </div> -->
            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Third Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Received From</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Received From"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Fourth Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Received By</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Received By"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
                <div class="col-sm-2"><label align= "text-center">Type of Inspection</label></div>

                <div class="col-sm-2">
                    <div class="btn-group">
                      <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> 
                        <span id="typeOfInspection">Choose Type of Inspection</span> <span class="caret"></span>
                      </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" id="repair" href="#" >Repair</a></li>
                          <li><a class="dropdown-item" id="deliveries" href="#">Deliveries</a></li>
                        </ul>
                              <Script>
                                $(function(){
                                  $("#repair").click(function () {
                                  $("#typeOfInspection").text($(this).text());
                                  });
                                  $("#deliveries").click(function () {
                                  $("#typeOfInspection").text($(this).text());
                                  });
                                });
                              </Script> 
                    </div>
                </div>

                <div class="col-sm-2">
                    <div class="btn-group">
                      <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> 
                        <span id="typeOfRepair">Choose Type</span> <span class="caret"></span>
                      </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" id="preRepair" href="#" >Pre-Repair</a></li>
                          <li><a class="dropdown-item" id="postRepair" href="#">Post-repair</a></li>
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
                      <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> 
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

                
                <div class=""><input type="text"  align= "text-center" placeholder="Others"></div>

            </div>

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class="row">
              <div class="col-sm-2"><label align= "text-center">To</label></div>
              <div class="col-sm-2">
                    

                    <div class="btn-group">
                      <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> 
                        <span id="receipeint">Choose inspector</span> <span class="caret"></span>
                      </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" id="per1" href="#" >Bardillon Jr., Ricardo</a></li>
                          <li><a class="dropdown-item" id="per2" href="#">Cacananta, Carlito</a></li>
                          <li><a class="dropdown-item" id="per3" href="#">Carillo, Loida B.</a></li>
                          <li><a class="dropdown-item" id="per4" href="#">Castro Jr., Salvador V.</a></li>
                        </ul>
                              <Script>
                                $(function(){
                                  $("#per1").click(function () {
                                  $("#receipeint").text($(this).text());
                                  });
                                  $("#per2").click(function () {
                                  $("#receipeint").text($(this).text());
                                  });
                                  $("#per3").click(function () {
                                  $("#receipeint").text($(this).text());
                                  });
                                  $("#per4").click(function () {
                                  $("#receipeint").text($(this).text());
                                  });
                                });
                              </Script> 
                    </div>
                </div>

            </div>

             <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
              
            <div class="row">
              <div class="col-sm-2"><label align= "text-center">Required Action</label></div>
              <div class="col-sm-2">
                    

                    <div class="btn-group">
                      <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> 
                        <span id="requiredAction">Choose action</span> <span class="caret"></span>
                      </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" id="ra_1" href="#" >For Inspection</a></li>
                          <li><a class="dropdown-item" id="ra_2" href="#">Please Prepare Report</a></li>
                          <li><a class="dropdown-item" id="ra_3" href="#">Others</a></li>
                          
                        </ul>
                              <Script>
                                $(function(){
                                  $("#ra_1").click(function () {
                                  $("#requiredAction").text($(this).text());
                                  });
                                  $("#ra_2").click(function () {
                                  $("#requiredAction").text($(this).text());
                                  });
                                  $("#ra_3").click(function () {
                                  $("#requiredAction").text($(this).text());
                                  });
                                });
                              </Script> 
                    </div>
                </div>

                <div><textarea rows="3" cols="100" placeholder="Others"></textarea> </div>

            </div><!-- end of row -->

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row"> <!-- Start of a new row -->

              <div class="col-sm-2"><label align= "text-center">Name</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Start of a new row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Designation</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Designation"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Date Request</label></div>
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
                   <!--<div class="form-group">
                    <div>
                     <button class="btn btn-primary " name="submit" type="submit">Submit</button>  
                    </div>
                   </div>
                   </form> 
                  </div> -->
            </div>
          </div><!-- end of panel-body -->





        <div class = "panel-heading panel-heading-custom">
            <div class= "row">
              <div class="col-sm-2"><label align= "text-left">Others</label></div>
            </div>
        </div>

          <div class="panel-body">
            <div class= "row">
              <div class="col-sm-4"><textarea rows="3" cols="170" placeholder="Others"></textarea> </div>              
            </div>     
          </div>

      </div> <!-- end of panel-default -->

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
                        <p align="center">                         
                            <button onclick="submitAIF()">Submit</button>
                        </p>
                        <br>
                        <br>
              
                 <!-- <tr><button type="button" class="btn btn-default">Create</button></tr><tr><button type="button" class="btn btn-default">Edit</button></tr><tr><button type="button" class="btn btn-default">View List</button></tr> -->
		</section><! --/wrapper -->
      </section>
     </section>
      <!-- /MAIN CONTENT -->
      </form>
      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" />
      <!--footer end-->
  </section>
      <jsp:include page="WEB-INF/footer.jsp" /> 
  </body>
</html>

