<%-- 
    Document   : costing
    Created on : 03 23, 18, 11:10:59 AM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | Costing</title>
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
                        Costing Tracker
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
			<div class="container-fluid">
      <h2>DAR</h2>
      <div class="panel panel-default">

         
            <div class="panel-body">           
                
                <div class = "row">
                  <!-- Search Inoput-->  
                  <div class="col-sm-2" class="form-group"> <input type="text"  align= "text-center" placeholder="Search"></div>             

    	              <!--Dropdown -->
    	              <div class="col-sm-2">
    	               <div class="btn-group">
    	                <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="reports"> 
    	                	<span id="opt">Choose</span> <span class="caret"></span>
    	                </button>
    	                  <ul class="dropdown-menu">
    	                    <li><a class="dropdown-item" id="1" href="#" >Costing</a></li>    	                       
    	                  </ul>
    	              </div>
    	              </div> 

    	              <Script>
    	              	$(function(){
            					    $("#1").click(function () {
            					    $("#opt").text($(this).text());
            					    });
            					    $("#2").click(function () {
            					    $("#opt").text($(this).text());
            					    });
            					    $("#3").click(function () {
            					    $("#opt").text($(this).text());
            					    });
            					    $("#4").click(function () {
            					    $("#opt").text($(this).text());
            					    });
    					        });
    	              </Script>                              
                </div> 
            </div>

            <div class = "panel-heading panel-heading-custom">
              <div class= "row">
                 <div class="col-sm-2"><label align= "text-center" id="one">Office Name</label></div>
                  <div class="col-sm-2"><label align= "text-center">Asset Type</label></div>
                  <div class="col-sm-2"><label align= "text-center">Total Budget</label></div>
                  <div class="col-sm-2"><label align= "text-center">Total Spent</label></div>
                  <div class="col-sm-2"><label align= "text-center">Remaining Budget</label></div>
                  
              </div>
            </div>         
        </div>
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

